import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ModalList from "./ModalList.jsx";
import AddModal from "./AddModal.jsx";
import UpdateModal from "./UpdateModal.jsx";
function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<ModalList />} />
          <Route path="/add-modal" element={<AddModal />} />
          <Route path="/update-modal/:id" element={<UpdateModal />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
