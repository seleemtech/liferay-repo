import ClayButton, {ClayButtonWithIcon} from "@clayui/button";
import Card from "./Card.es";
import ClayForm, {ClayInput, ClaySelect} from "@clayui/form";
import React, {useState} from "react";
import '../scss/form..scss';
import {useForm} from "react-hook-form";

const UpdateProjectStatus = (props) => {
    const {apiUrl,projectId, statusList, selectedStatus} = props;
    const {register, handleSubmit, setValue, errors} = useForm();
    const [selectedProjectStatus, setSelectedProjectStatus] = useState('');
    const [isProjectStatusError, setIsProjectStatusError] = useState(false);
    const closePanel = () => {
        const parentWindow = Liferay.Util.getOpener();
        parentWindow.Liferay.fire('close-side-panel');
    }

    const onSubmit = (data) => {
        // Check if any selectedProjectStatus is empty and set the hasError flag
        if (!selectedProjectStatus) {
            setIsProjectStatusError(true);
        }else {
            console.log("Submit form value"+selectedProjectStatus);
            postProjectStatus(selectedProjectStatus);
            Liferay.Util.openToast({
                autoClose: false,
                message: 'Project Status Updated',
                type: 'success'
            });
            saveAndReload();
        }
    };
    const postProjectStatus = (selectedProjectStatus) => {
        const username = 'admin@esquare.com';
        const password = 'test';
        /*  'Authorization': `Bearer ${bearerToken}`,*/
        const base64Credentials = btoa(username + ':' + password);
        fetch(apiUrl, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + base64Credentials,
            },
            body: JSON.stringify({
                id: projectId,
                statusCode: selectedProjectStatus
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
                    className="panel_content"
                >
                    <div className="panel_header">
                        <div className="panel_title">
                            <h3 className="mb-0">{"Project Status"}</h3>
                        </div>

                        <ClayButtonWithIcon
                            aria-label={Liferay.Language.get('cancel')}
                            displayType="unstyled"
                            monospaced={false}
                            onClick={closePanel}
                            symbol="times"
                        />
                    </div>
                    {selectedStatus && (
                        <Card title={Liferay.Language.get('Current Project Status')}>
                            {selectedStatus && (
                                <ClayForm.Group>
                                    <label htmlFor="status">Status</label>
                                    <ClayInput
                                        id="status"
                                        name="status"
                                        type="text"
                                        readOnly={true}
                                        value={selectedStatus}
                                    />
                                </ClayForm.Group>
                            )}
                        </Card>
                    )}

                    <Card title={"Update Status"}>
                        <ClayForm.Group className={isProjectStatusError ? "has-error" : ""}>
                            <label htmlFor="projectStatus">Project Status</label>
                            <ClaySelect
                                aria-label="Select Project Status"
                                name="projectStatus"
                                onChange={(event) => {
                                    setSelectedProjectStatus(event.target.value);
                                    if (event.target.value === '') {
                                        setIsProjectStatusError(true);
                                    } else {
                                        setIsProjectStatusError(false);
                                    }
                                }}
                            >
                                <ClaySelect.Option label="Select a Project Status" value=""/>
                                {Object.entries(statusList).map(([key, Value]) => (
                                        <ClaySelect.Option
                                            key={key}
                                            label={Value}
                                            value={key}
                                        />
                                    )
                                )}
                            </ClaySelect>

                            {isProjectStatusError && (
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
};

export default UpdateProjectStatus;