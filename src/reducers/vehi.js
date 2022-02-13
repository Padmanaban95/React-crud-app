import {
    CREATE_VEHICLE,
    RETRIEVE_VEHICLE,
    RETRIEVE_VEHICLE_BYID,
    UPDATE_VEHICLE,
    DELETE_VEHICLE,
  } from "../action/type";
  const initial = [];
  function reducer(vehicles = initial, action){
      const{type, payload} = action;
      switch(type){
          case CREATE_VEHICLE:
              return [...vehicles, payload];
          case  RETRIEVE_VEHICLE:
              return payload;
          case RETRIEVE_VEHICLE_BYID:
              return vehicles.filter(({id}) => id === payload.id);
          case UPDATE_VEHICLE:
              return vehicles.map((vehicle) => {
                  if (vehicle.id === payload.id){
                      return {
                          ...vehicle,
                          ...payload
                        };
                    }else{
                        return vehicle;
                    }
                });
          case DELETE_VEHICLE:
                return vehicles.filter(({id}) => id !== payload.id); 
          default:
              return vehicles;
        }
    }; 
    export default reducer;