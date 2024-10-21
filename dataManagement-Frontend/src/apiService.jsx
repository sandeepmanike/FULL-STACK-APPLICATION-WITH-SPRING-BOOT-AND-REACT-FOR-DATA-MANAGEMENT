import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/v1";

export const getAllModals = () => {
  return axios.get(`${API_BASE_URL}/getstud`);
};

export const getModalById = (id) => {
  return axios.get(`${API_BASE_URL}/getstud/${id}`);
};

export const createModal = (modal) => {
  return axios.post(`${API_BASE_URL}/pm`, modal);
};

export const updateModal = (id, modal) => {
  return axios.put(`${API_BASE_URL}/upd/${id}`, modal);
};

export const deleteModal = (id) => {
  return axios.delete(`${API_BASE_URL}/del/${id}`);
};
