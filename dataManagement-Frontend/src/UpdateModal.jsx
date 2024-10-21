import React, { useState, useEffect } from "react";
import { getModalById, updateModal } from "./apiService";
import { useParams } from "react-router-dom";

const UpdateModal = () => {
  const { id } = useParams();
  const [firstName, setFirstName] = useState("");

  useEffect(() => {
    fetchModal();
  }, []);

  const fetchModal = async () => {
    const response = await getModalById(id);
    setFirstName(response.data.firstName);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const updatedModal = { firstName };
    await updateModal(id, updatedModal);
  };

  return (
    <div>
      <h2>Update Modal</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
          placeholder="First Name"
          required
        />
        <button type="submit">Update</button>
      </form>
    </div>
  );
};

export default UpdateModal;
