import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Scanner from "./pages/Scanner";
import Form from "./pages/Form";
import { Provider } from "react-redux";
import store from "./store/store"

function App() {
  return (
    <>
    <Provider store={store}>
      <BrowserRouter>
      <Routes>
        <Route path="/" Component={Login}/>
        <Route path="/scanner" Component={Scanner}/>
        <Route path="/form" Component={Form}/>
      </Routes>
    </BrowserRouter>

    </Provider>
    
  
    
    </>
  );
}

export default App;
