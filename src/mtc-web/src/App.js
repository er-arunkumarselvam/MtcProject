import { BrowserRouter, Routes, Route, useLocation } from "react-router-dom";
import Login from "./pages/Login";
import Scanner from "./pages/Scanner";
import Form from "./pages/Form";
import { Provider } from "react-redux";
import store from "./store/store";
import ProtectedRoute from "./router/ProtectedRoute";
import { UserNavbar } from "./components/UserNavbar";

const App = () => {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <AppRoutes />
      </BrowserRouter>
    </Provider>
  );
};

const AppRoutes = () => {
  const location = useLocation();
  const showNavbar = location.pathname !== "/";

  return (
    <>
      {showNavbar && <UserNavbar />}
      <Routes>
        <Route path="/" Component={Login} />
        <Route Component={ProtectedRoute}>
          <Route path="/scanner" Component={Scanner} />
          <Route path="/form" Component={Form} />
        </Route>
      </Routes>
    </>
  );
};

export default App;
