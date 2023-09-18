import { RouterProvider } from 'react-router-dom';
import './App.css';
import { GlobalToastrProvider } from './contexts/toastr/toastr.context';
import { router } from './router';
import { Toastr } from './ui/components';

function App() {
  return (
    <GlobalToastrProvider>
      <div className="App">
        <RouterProvider router={router} />
        <Toastr />
      </div>
    </GlobalToastrProvider>
  );
}

export default App;
