import React, { useState } from "react";
import { createModal } from "./apiService";

const AddModal = () => {
  const [firstName, setFirstName] = useState("");
  const [id, setId] = useState("");
  const handleSubmit = async (e) => {
    e.preventDefault();
    const newModal = { firstName, id: Number(id) }; // Convert id to a number
    try {
      await createModal(newModal);
      setFirstName(""); // Clear form after submission
      setId(""); // Clear id field after submission
    } catch (error) {
      console.error("Error during form submission:", error);
    }
  };

  return (
    <div>
      <h2>Add Modal</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
          placeholder="First Name (Required)"
          required
        />
        <input
          type="number" // Use number type for id
          value={id}
          onChange={(e) => setId(e.target.value)}
          placeholder="ID (Required)"
        />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AddModal;
