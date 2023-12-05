import React, {useEffect, useState} from 'react';
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import ClayDatePicker from '@clayui/date-picker';
import ClayForm, {ClayCheckbox, ClayDualListBox, ClayInput, ClaySelect} from '@clayui/form';
import {useForm} from 'react-hook-form';
import Card from "./Card.es";
import ClayAlert from "@clayui/alert";

const EditTask = (props) => {
        const {
            apiUrl,
            taskName,
            taskDesc,
            projectCode,
            projectDeveloperList,
            projectTesterList,
            taskId,
            taskStartDate,
            taskEndDate
        } = props;
        const {register, handleSubmit, errors, watch} = useForm();
        const [updatedTaskName, setUpdatedTaskName] = useState(taskName);
        const [updatedTaskDesc, setUpdatedTaskDesc] = useState(taskDesc);

        function formatToDatePickerFormat(dateString) {
            const startDate = new Date(dateString);
            const formattedDate = startDate.toLocaleDateString('en-GB', {
                year: 'numeric',
                month: '2-digit',
                day: '2-digit'
            });
            const parts = formattedDate.split('/'); // Split the date string
            let formattedDateForDatePicker;
            if (parts.length === 3) {
                const dd = parts[0];
                const mm = parts[1];
                const yyyy = parts[2];

                // Create a new formatted date string in "YYYY-MM-DD" format
                formattedDateForDatePicker = `${yyyy}-${mm}-${dd}`;
            }

            return formattedDateForDatePicker;
        }

        const closePanel = () => {
            const parentWindow = Liferay.Util.getOpener();
            parentWindow.Liferay.fire('close-side-panel');
        }

        const panel_header = {
            alignItems: 'center',
            background: '#fff',
            borderBottom: '1px solid #e7e7ed',
            display: 'flex',
            height: '65px',
            justifyContent: 'space-between',
            padding: '0.25rem 0rem',
            position: 'sticky',
            top: '55px',
            zIndex: '10',
        };
        const panel_content = {
            background: '#f7f8f9',
            minHeight: '100vh',
        };

        const panel_title = {
            display: 'flex',
            flexDirection: 'column',
            padding: '1rem',
        }

        const validateEndDate = (endDate, startDate) => {
            if (endDate < startDate) {
                return "End date cannot be earlier than start date";
            }
            return true;
        };
        const developerMoveBoxesOptions = [];
        Object.entries(projectDeveloperList).forEach(([key, value]) => {
            if (Array.isArray(value)) {
                const convertedList = value.map((item) => ({
                    label: item.label,
                    value: item.value,
                }));
                developerMoveBoxesOptions.push(convertedList);
            }
        });
        const [developerItems, setDeveloperItems] = useState(developerMoveBoxesOptions);
        const [developerLeftSelected, setDeveloperLeftSelected] = useState([]);
        const [developerRightSelected, setDeveloperRightSelected] = useState([]);
        const [isDeveloperEmpty, setDeveloperEmpty] = useState(false);

        const testerMoveBoxesOptions = [];
        Object.entries(projectTesterList).forEach(([key, value]) => {
            if (Array.isArray(value)) {
                const convertedList = value.map((item) => ({
                    label: item.label,
                    value: item.value,
                }));
                testerMoveBoxesOptions.push(convertedList);
            }
        });
        const [testerItems, setTesterItems] = useState(testerMoveBoxesOptions);
        const [testerLeftSelected, setTesterLeftSelected] = useState([]);
        const [testerRightSelected, setTesterRightSelected] = useState([]);
        const [isTesterEmpty, setTesterEmpty] = useState(false);
        const onSubmit = (data) => {
            const developerId = developerItems[1].map(item => item.value);
            const testerId = testerItems[1].map(item => item.value);

            if (developerId.length === 0) {
                setDeveloperEmpty(true);
            } else {
                setDeveloperEmpty(false);
            }
            if (testerId.length === 0) {
                setTesterEmpty(true);
            } else {
                setTesterEmpty(false);
            }
            if (developerId.length > 0 && testerId.length > 0) {

                const developerIds = developerId.join(',');
                const testerIds = testerId.join(',');
                updateTaskDetails(data.taskName, data.taskDescription, data.taskStartDate, data.taskEndDate, developerIds, testerIds);
                Liferay.Util.openToast({
                    autoClose: true,
                    message: 'Task updated SuccessFully',
                    type: 'success'
                });
                saveAndReload();
            }
        }

        const updateTaskDetails = (taskName, taskDesc, startDate, endDate, developerIds, testerIds) => {
            const username = 'admin@esquare.com';
            const password = 'test';
            /*  'Authorization': `Bearer ${bearerToken}`,*/
            const base64Credentials = btoa(username + ':' + password);
            fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Basic ' + base64Credentials,
                },
                body: JSON.stringify({
                    id: taskId,
                    name: taskName,
                    description: taskDesc,
                    developmentTeamIds: developerIds,
                    testerTeamIds: testerIds,
                    taskStartDate: startDate,
                    taskEndDate: endDate
                }),
            })
                .then((response) => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then((data) => {
                })
                .catch((error) => {
                    Liferay.Util.openToast({
                        autoClose: false,
                        message: Liferay.Language.get(
                            'an-unexpected-system-error-occurred'
                        ),
                        type: 'danger',
                    });
                });

        }

        function saveAndReload() {
            setTimeout(() => {
                closePanel();
                window.location.reload();
            }, 2000);
        }

        return (
            <>
                <ClayForm onSubmit={handleSubmit(onSubmit)}>
                    <div
                        style={panel_content}
                    >
                        <div style={panel_header}>
                            <div style={panel_title}>
                                <h3 className="mb-0">Task Details</h3>
                            </div>

                            <ClayButtonWithIcon
                                aria-label={Liferay.Language.get('cancel')}
                                displayType="unstyled"
                                monospaced={false}
                                onClick={closePanel}
                                symbol="times"
                            />
                        </div>
                        <Card title={Liferay.Language.get('Basic Task Info')}>
                            <ClayForm.Group>
                                <label htmlFor="projectCode">Project Code</label>
                                <ClayInput
                                    id="projectCode"
                                    name="projectCode"
                                    type="text"
                                    readOnly={true}
                                    value={projectCode}
                                />
                            </ClayForm.Group>
                            <ClayForm.Group className={errors.taskName ? "has-error" : ""}>
                                <label htmlFor="taskName">Task Name</label>
                                <ClayInput
                                    id="taskName"
                                    name="taskName"
                                    type="text"
                                    value={updatedTaskName}
                                    onChange={event => setUpdatedTaskName(event.target.value)}
                                    ref={register({required: 'This field is required'})}
                                />
                                {errors.taskName && (
                                    <ClayForm.FeedbackItem>
                                        <ClayForm.FeedbackIndicator
                                            symbol="exclamation-full"
                                        />
                                        {"This field is required."}
                                    </ClayForm.FeedbackItem>
                                )}

                            </ClayForm.Group>
                            <ClayForm.Group>
                                <label htmlFor="taskDescription">Description</label>
                                <ClayInput
                                    id="taskDescription"
                                    name="taskDescription"
                                    type="text"
                                    value={updatedTaskDesc}
                                    onChange={event => setUpdatedTaskDesc(event.target.value)}
                                    ref={register({required: false})}
                                />
                            </ClayForm.Group>
                        </Card>
                        <Card title={Liferay.Language.get('Duration')}>
                            <ClayAlert displayType="info" title="Note">
                                By default, Task startDate and endDate considered as a Project Development startDate and Delivery Estimated Date.
                            </ClayAlert>
                            <ClayForm.Group className={errors.taskStartDate ? "has-error" : ""}>
                                <label htmlFor="taskStartDate">Task Start Date</label>
                                <ClayDatePicker
                                    id="taskStartDate"
                                    name="taskStartDate"
                                    placeholder="YYYY-MM-DD"
                                    value={formatToDatePickerFormat(taskStartDate)}
                                    years={{
                                        end: 2024,
                                        start: 1997
                                    }}
                                    ref={register({required: 'This field is required'})}
                                />
                                {errors.taskStartDate && (
                                    <ClayForm.FeedbackItem>
                                        <ClayForm.FeedbackIndicator
                                            symbol="exclamation-full"
                                        />
                                        {"This field is required."}
                                    </ClayForm.FeedbackItem>
                                )}

                            </ClayForm.Group>
                            <ClayForm.Group className={errors.taskEndDate ? "has-error" : ""}>
                                <label htmlFor="taskEndDate">Task End Date</label>
                                <ClayDatePicker
                                    id="taskEndDate"
                                    name="taskEndDate"
                                    placeholder="YYYY-MM-DD"
                                    value={formatToDatePickerFormat(taskEndDate)}
                                    years={{
                                        end: 2024,
                                        start: 1997
                                    }}
                                    ref={register({
                                        required: 'This field is required',
                                        validate: {
                                            endDateGreaterThanStartDate: value =>
                                                validateEndDate(value, watch('taskStartDate'))
                                        }
                                    })}
                                />
                                {errors.taskEndDate && (
                                    <ClayForm.FeedbackItem>
                                        <ClayForm.FeedbackIndicator symbol="exclamation-full"/>
                                        {'End date cannot be earlier than start date'}
                                    </ClayForm.FeedbackItem>
                                )}
                            </ClayForm.Group>
                        </Card>
                        <Card title={Liferay.Language.get('Assign Resources')}
                        >
                            <ClayForm.Group className={isDeveloperEmpty ? "has-error" : ""}>
                                <ClayDualListBox
                                    left={{
                                        label: "Available Project Developer Resources",
                                        onSelectChange: setDeveloperLeftSelected,
                                        selected: developerLeftSelected
                                    }}
                                    onItemsChange={setDeveloperItems}
                                    right={{
                                        label: "Project Developer Team",
                                        onSelectChange: setDeveloperRightSelected,
                                        selected: developerRightSelected,
                                    }}
                                    items={developerItems}
                                    size={8}
                                />
                                {isDeveloperEmpty && (
                                    <ClayForm.FeedbackGroup>
                                        <ClayForm.FeedbackItem>
                                            <ClayForm.FeedbackIndicator
                                                symbol="exclamation-full"
                                            />
                                            {"This field is required"}
                                        </ClayForm.FeedbackItem>
                                    </ClayForm.FeedbackGroup>
                                )}
                            </ClayForm.Group>
                            <ClayForm.Group className={isTesterEmpty ? "has-error" : ""}>
                                <ClayDualListBox
                                    items={testerItems}
                                    left={{
                                        label: "Available Project Tester Resources",
                                        onSelectChange: setTesterLeftSelected,
                                        selected: testerLeftSelected
                                    }}
                                    onItemsChange={setTesterItems}
                                    right={{
                                        label: "Project Tester Team",
                                        onSelectChange: setTesterRightSelected,
                                        selected: testerRightSelected
                                    }}
                                    size={8}
                                />
                                {isTesterEmpty && (
                                    <ClayForm.FeedbackGroup>
                                        <ClayForm.FeedbackItem>
                                            <ClayForm.FeedbackIndicator
                                                symbol="exclamation-full"
                                            />
                                            {"This field is required"}
                                        </ClayForm.FeedbackItem>
                                    </ClayForm.FeedbackGroup>
                                )}
                            </ClayForm.Group>
                        </Card>

                        <ClayButton.Group
                            className="custom-button-container"
                            spaced
                        >
                            <ClayButton displayType="secondary" onClick={closePanel}>
                                {Liferay.Language.get('cancel')}
                            </ClayButton>

                            <ClayButton type="submit">
                                {Liferay.Language.get('save')}
                            </ClayButton>
                        </ClayButton.Group>
                    </div>

                </ClayForm>

            </>
        );
    }
;


export default EditTask;
