import {
    CREATE_VEHICLE,
    RETRIEVE_VEHICLE,
    RETRIEVE_VEHICLE_BYID,
    UPDATE_VEHICLE,
    DELETE_VEHICLE,
  } from "./type";
  import Vehicledata from "../data/vehicledata";
import vehicledata from "../data/vehicledata";
  export const createvehicle = (id, year, make, model) => async (dispatch) => {
    try {
      const vehi = await vehicledata.create({ id, year, make, model });
      dispatch({
        type: CREATE_VEHICLE,
        payload: vehi.data,
      });
      return Promise.resolve(vehi.data);
    } catch (err) {
      return Promise.reject(err);
    }
  };
  export const retrievevehicle = () => async (dispatch) => {
    try {
      const vehi = await vehicledata.getAll();
      dispatch({
        type: RETRIEVE_VEHICLE,
        payload: vehi.data,
      });
    } catch (err) {
      console.log(err);
    }
  };
  export const retrievevehiclebyid = (id) => async (dispatch) => {
    try {
      const vehi = await vehicledata.get(id);
      dispatch({
        type: RETRIEVE_VEHICLE_BYID,
        payload: vehi.data,
      });
    } catch (err) {
      console.log(err);
    }
  };
  export const updatevehicle = (id, data) => async (dispatch) => {
    try {
      const vehi = await vehicledata.update(id, data);
      dispatch({
        type: UPDATE_VEHICLE,
        payload: data,
      });
      return Promise.resolve(vehi.data);
    } catch (err) {
      return Promise.reject(err);
    }
  };
  export const deletevehicle = (id) => async (dispatch) => {
    try {
      await vehicledata.delete(id);
      dispatch({
        type: DELETE_VEHICLE,
        payload: { id },
      });
    } catch (err) {
      console.log(err);
    }
  };
 
  
  