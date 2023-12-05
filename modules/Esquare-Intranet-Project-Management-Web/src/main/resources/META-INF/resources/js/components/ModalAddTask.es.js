import React, {useEffect, useState} from 'react';
import ClayButton from '@clayui/button';
import ClayModal, {useModal} from '@clayui/modal';
import ClayForm, {ClayInput} from '@clayui/form';
import {useForm} from 'react-hook-form';

const ModalAddTask = (props) => {
    const {apiUrl, projectId} = props;
    const {register, handleSubmit, errors} = useForm();
    const [visibleModal, setVisibleModal] = useState(false);
    const [bearerToken, setBearerToken] = useState('');
    const [tokenExpirationTime, setTokenExpirationTime] = useState(0);
    const {observer, onClose} = useModal({
        onClose: () => setVisibleModal(false),
    });
    useEffect(() => {
        Liferay.on('addTask', () => setVisibleModal(true));
        return () => {
            Liferay.detach('addTask', () =>
                setVisibleModal(true)
            );
        };
    }, []);

    const onSubmit = (data) => {
        /*  getBearerToken();*/
        postTaskDetails(data.taskName, data.taskDescription);
        saveAndReload();
        Liferay.Util.openToast({
            autoClose: false,
            message: 'Task Created SuccessFully',
            type: 'success'
        });
    };

    function getBearerToken() {
        const clientId = 'id-f7cf3592-37db-8785-a0ab-8dc3af7bb711';
        const clientSecret = 'secret-a873501a-e252-aed4-302c-d7265f6328';

        // Check if the token has already been obtained and is not expired
        const currentTime = Date.now();
        if (bearerToken && tokenExpirationTime && tokenExpirationTime > currentTime) {
            console.log("old token" + bearerToken);
            return;
        }

        const url = `http://localhost:8080/o/oauth2/token?grant_type=client_credentials&client_id=${clientId}&client_secret=${clientSecret}`;

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                console.log("data", data);
                const newBearerToken = data.access_token;
                console.log("newBearerToken" + newBearerToken);
                const newExpirationTime = currentTime + (data.expires_in * 1000); // Convert seconds to milliseconds

                setBearerToken(newBearerToken);
                setTokenExpirationTime(newExpirationTime);
            })
            .catch((error) => {
                Liferay.Util.openToast({
                    autoClose: false,
                    message: error,
                    type: 'danger',
                });
            });
    }

    function saveAndReload() {
        const parentWindow = Liferay.Util.getOpener();
        setVisibleModal(false);
        setTimeout(() => {
            window.location.reload();
        }, 1000);
    }

    const postTaskDetails = (taskName, taskDescription) => {
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
                name: taskName,
                description: taskDescription,
                projectId: projectId

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
            {visibleModal && (
                <ClayModal observer={observer}>
                    <ClayForm onSubmit={handleSubmit(onSubmit)}>
                        <ClayModal.Header>Add Task</ClayModal.Header>
                        <ClayModal.Body>
                            <ClayForm.Group className={errors.taskName ? "has-error" : ""}>
                                <label htmlFor="taskName">Task Name</label>
                                <ClayInput
                                    id="taskName"
                                    name="taskName"
                                    type="text"
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
                                    ref={register({required: false})}
                                />
                            </ClayForm.Group>

                        </ClayModal.Body>
                        <ClayModal.Footer
                            last={
                                <ClayButton.Group spaced>
                                    <ClayButton
                                        displayType="secondary"
                                        onClick={() => setVisibleModal(false)}
                                    >
                                        Cancel
                                    </ClayButton>
                                    <ClayButton type="submit">Save</ClayButton>
                                </ClayButton.Group>
                            }
                        />
                    </ClayForm>
                </ClayModal>
            )}
        </>
    );
};


export default ModalAddTask;
