import React, {useEffect, useState} from 'react';
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import ClayForm, {ClayInput, ClaySelect} from '@clayui/form';
import {useForm} from 'react-hook-form';
import Card from "./Card.es";
import ClayAlert from "@clayui/alert";

const AssignResources = (props) => {
    const {
        apiUrl,
        projectManagerUser,
        deliveryLeadUser,
        operationLeadUser,
        projectQALeadUser,
        projectId,
        selectedPM,
        selectedDL,
        selectedPQL,
        selectedOL
    } = props;
    const {register, handleSubmit, setValue, errors} = useForm();
    const [selectedPmId, setSelectedPmId] = useState('');
    const [selectedDlId, setSelectedDlId] = useState('');
    const [selectedOlId, setSelectedOlId] = useState('');
    const [selectedQalId, setSelectedQalId] = useState('');
    const [isPmIdError, setIsPmIdError] = useState(false);
    const [isDlIdError, setIsDlIdError] = useState(false);
    const [isOlIdError, setIsOlIdError] = useState(false);
    const [isQalIdError, setIsQalIdError] = useState(false);
    const fieldStateMap = [
        {fieldValue: selectedPmId, setState: setIsPmIdError},
        {fieldValue: selectedDlId, setState: setIsDlIdError},
        {fieldValue: selectedOlId, setState: setIsOlIdError},
        {fieldValue: selectedQalId, setState: setIsQalIdError},
    ];
    const closePanel = () => {
        const parentWindow = Liferay.Util.getOpener();
        parentWindow.Liferay.fire('close-side-panel');
    }
    useEffect(() => {
        // Find the key that matches the selectedPM value
        const matchingKey = Object.entries(projectManagerUser).find(([key, Value]) => selectedPM === Value)?.[0];
        // If a matching key is found, update selectedPmId
        if (matchingKey) {
            setSelectedPmId(matchingKey);
        }
    }, [selectedPM, projectManagerUser]);
    useEffect(() => {
        const matchingKey = Object.entries(deliveryLeadUser).find(([key, Value]) => selectedDL === Value)?.[0];
        if (matchingKey) {
            setSelectedDlId(matchingKey);
        }
    }, [selectedDL, deliveryLeadUser]);
    useEffect(() => {
        const matchingKey = Object.entries(operationLeadUser).find(([key, Value]) => selectedOL === Value)?.[0];
        if (matchingKey) {
            setSelectedOlId(matchingKey);
        }
    }, [selectedOL, operationLeadUser]);
    useEffect(() => {
        const matchingKey = Object.entries(projectQALeadUser).find(([key, Value]) => selectedPQL === Value)?.[0];
        if (matchingKey) {
            setSelectedQalId(matchingKey);
        }
    }, [selectedPQL, projectQALeadUser]);

    const showCard = selectedPM || selectedDL || selectedOL || selectedPQL;
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

    const onSubmit = (data) => {
        fieldStateMap.forEach((field) => {
            if (!eval(field.fieldValue)) {
                field.setState(true);
            }
        });
        let hasError = false;
        // Check if any field is empty and set the hasError flag
        if (!selectedPmId || !selectedDlId || !selectedOlId || !selectedQalId) {
            hasError = true;
        }

        // If there are no errors, proceed with the form submission
        if (!hasError) {
            postAssignResourceDetails(selectedPmId, selectedDlId, selectedOlId, selectedQalId)
            Liferay.Util.openToast({
                autoClose: false,
                message: 'Resource Assigned SuccessFully',
                type: 'success'
            });
            saveAndReload();
        }
    };

    function saveAndReload() {
        setTimeout(() => {
            closePanel();
            window.location.reload();
        }, 2000);
    }

    const postAssignResourceDetails = (pmId, dlId, olId, qlId) => {
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
                pmId: pmId,
                dlId: dlId,
                olId: olId,
                qlId: qlId

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
    return (
        <>
            <ClayForm onSubmit={handleSubmit(onSubmit)}>
                <div
                    style={panel_content}
                >
                    <div style={panel_header}>
                        <div style={panel_title}>
                            <h3 className="mb-0">{showCard ? "Edit Resources" : "Assign Resources"}</h3>
                        </div>

                        <ClayButtonWithIcon
                            aria-label={Liferay.Language.get('cancel')}
                            displayType="unstyled"
                            monospaced={false}
                            onClick={closePanel}
                            symbol="times"
                        />
                    </div>
                    {showCard &&(
                    <Card title={Liferay.Language.get('Resources')}>
                        {selectedPM && (
                            <ClayForm.Group>
                                <label htmlFor="projectManager">Project Manager</label>
                                <ClayInput
                                    id="projectManager"
                                    name="projectManager"
                                    type="text"
                                    readOnly={true}
                                    value={selectedPM}
                                />
                            </ClayForm.Group>
                        )}
                        {selectedDL && (
                            <ClayForm.Group>
                                <label htmlFor="deliveryLead">Delivery Lead</label>
                                <ClayInput
                                    id="deliveryLead"
                                    name="deliveryLead"
                                    type="text"
                                    readOnly={true}
                                    value={selectedDL}
                                />
                            </ClayForm.Group>
                        )}
                        {selectedOL && (
                            <ClayForm.Group>
                                <label htmlFor="operationLead">Operation Lead</label>
                                <ClayInput
                                    id="operationLead"
                                    name="operationLead"
                                    type="text"
                                    readOnly={true}
                                    value={selectedOL}
                                />

                            </ClayForm.Group>
                        )}
                        {selectedPQL && (
                            <ClayForm.Group>
                                <label htmlFor="projectQaLead">Project QA Lead</label>
                                <ClayInput
                                    id="projectQaLead"
                                    name="projectQaLead"
                                    type="text"
                                    readOnly={true}
                                    value={selectedPQL}
                                />
                            </ClayForm.Group>
                        )}
                    </Card>
                    )}

                    <Card title={<ClayAlert displayType="info" title="Info">
                        Before assigning add resources
                    </ClayAlert>}
                    >
                        <ClayForm.Group className={isPmIdError ? "has-error" : ""}>
                            <label htmlFor="projectManager">Project Manager</label>
                            <ClaySelect
                                aria-label="Select Project Manager"
                                name="pmId"
                                onChange={(event) => {
                                    setSelectedPmId(event.target.value);
                                    if (event.target.value === '') {
                                        setIsPmIdError(true);
                                    } else {
                                        setIsPmIdError(false);
                                    }
                                }}
                            >
                                <ClaySelect.Option label="Select a Project Manager" value=""/>
                                {Object.entries(projectManagerUser).map(([key, Value]) => (
                                        <ClaySelect.Option
                                            key={key}
                                            label={Value}
                                            value={key}
                                            selected={selectedPM === Value}
                                        />
                                    )
                                )}
                            </ClaySelect>

                            {isPmIdError && (
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

                        <ClayForm.Group className={isDlIdError ? "has-error" : ""}>
                            <label htmlFor="deliveryLead">Delivery Lead</label>
                            <ClaySelect aria-label="Select Delivery Lead" name="dlId"
                                        onChange={(event) => {
                                            setSelectedDlId(event.target.value);
                                            if (event.target.value === '') {
                                                setIsDlIdError(true);
                                            } else {
                                                setIsDlIdError(false);
                                            }
                                        }}
                            >
                                <ClaySelect.Option label="Select Delivery Lead" value=""/>
                                {Object.entries(deliveryLeadUser).map(([key, Value]) => (
                                    <ClaySelect.Option
                                        key={key}
                                        label={Value}
                                        value={key}
                                        selected={selectedDL === Value}
                                    />
                                ))}
                            </ClaySelect>
                            {isDlIdError && (
                                <ClayForm.FeedbackItem>
                                    <ClayForm.FeedbackIndicator
                                        symbol="exclamation-full"
                                    />
                                    {"This field is required."}
                                </ClayForm.FeedbackItem>
                            )}
                        </ClayForm.Group>

                        <ClayForm.Group className={isOlIdError ? "has-error" : ""}>
                            <label htmlFor="operationLead">Operation Lead</label>
                            <ClaySelect aria-label="Select Operation Lead" name="olId"
                                        onChange={(event) => {
                                            setSelectedOlId(event.target.value);
                                            if (event.target.value === '') {
                                                setIsOlIdError(true);
                                            } else {
                                                setIsOlIdError(false);
                                            }
                                        }}>
                                <ClaySelect.Option label="Select Operation Lead" value=""/>
                                {Object.entries(operationLeadUser).map(([key, Value]) => (
                                    <ClaySelect.Option
                                        key={key}
                                        label={Value}
                                        value={key}
                                        selected={selectedOL === Value}
                                    />
                                ))}
                            </ClaySelect>
                            {isOlIdError && (
                                <ClayForm.FeedbackItem>
                                    <ClayForm.FeedbackIndicator
                                        symbol="exclamation-full"
                                    />
                                    {"This field is required."}
                                </ClayForm.FeedbackItem>
                            )}
                        </ClayForm.Group>
                        <ClayForm.Group className={isQalIdError ? "has-error" : ""}>
                            <label htmlFor="projectQaLead">QA Lead</label>
                            <ClaySelect aria-label="Select QA Lead" name="qlId"
                                        onChange={(event) => {
                                            setSelectedQalId(event.target.value);
                                            if (event.target.value === '') {
                                                setIsQalIdError(true);
                                            } else {
                                                setIsQalIdError(false);
                                            }
                                        }}>
                                <ClaySelect.Option label="Select QA Lead" value=""/>
                                {Object.entries(projectQALeadUser).map(([key, Value]) => (
                                    <ClaySelect.Option
                                        key={key}
                                        label={Value}
                                        value={key}
                                        selected={selectedPQL === Value}
                                    />
                                ))}
                            </ClaySelect>
                            {isQalIdError && (
                                <ClayForm.FeedbackItem>
                                    <ClayForm.FeedbackIndicator
                                        symbol="exclamation-full"
                                    />
                                    {"This field is required."}
                                </ClayForm.FeedbackItem>
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


export default AssignResources;
