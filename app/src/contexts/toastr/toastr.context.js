import createGlobalState from "react-create-global-state";

const initialState = "";

const [useGlobalToastr, GlobalToastrProvider] = createGlobalState(initialState);

export { useGlobalToastr, GlobalToastrProvider };
