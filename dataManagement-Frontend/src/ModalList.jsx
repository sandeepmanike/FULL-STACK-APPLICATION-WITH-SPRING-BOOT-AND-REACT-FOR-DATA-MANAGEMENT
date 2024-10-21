import React, { useEffect, useState } from "react";
import { getAllModals, deleteModal } from "./apiService";

const ModalList = () => {
  const [modals, setModals] = useState([]);

  useEffect(() => {
    fetchModals();
  }, []);

  const fetchModals = async () => {
    const response = await getAllModals();
    setModals(response.data);
  };

  const handleDelete = async (id) => {
    await deleteModal(id);
    fetchModals(); // Refresh list after deletion
  };

  return (
    <div>
      <h2>Modal List</h2>
      <ul>
        {modals.map((modal) => (
          <li key={modal.id}>
            {modal.id}
            {modal.firstName}
            <button onClick={() => handleDelete(modal.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ModalList;
