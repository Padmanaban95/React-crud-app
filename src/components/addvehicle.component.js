import React, { Component } from "react";
import vehicledata from "../data/vehicledata";
import { connect } from "react-redux";
import { createvehicle } from "../action/vehicles";
import { applyMiddleware } from "redux";
import App from "../App";
class Addvehicle extends Component {
    constructor(props){
        super(props);
        this.onChangeid = this.onChangeid.bind(this);
        this.onChangeyear = this.onChangeyear.bind(this);
        this.onChangemake = this.onChangemake.bind(this);
        this.onChangemodel = this.onChangemodel.bind(this);
        this.savevehicle = this.savevehicle.bind(this);
        this.newvehicle = this.newvehicle.bind(this);
        this.state = {
            id : "",
            year : "",
            make : "",
            model : "",
            submitted : false
        };
    }
    onChangeid(e){
        this.setState({
            id : e.target.value
        });
    }
    onChangeyear(e){
        this.setState({
            year : e.target.value

        });
    }
    onChangemake(e){
        this.setState({
            make : e.target.value
        });
    }
    onChangemodel(e){
        this.setState({
            model : e.taget.value
        });
    }
    savevehicle(){
        const {id, year, make, model} = this.state;
        this.props
        .createvehicle(id, year, make, model)
        .then((data) => {
            this.setState({
                id : data.id,
                year : data.year,
                make: data.make,
                model : data,model,
                submitted : true,
            });
            console.log(data);
        })
        
        
        .catch(e => {
            console.log(e);
        });
    }
    newvehicle(){
        this.setState({
            id : "",
            year : "",
            make : "",
            model : "",
            submitted : false
        });

    }
    render(){
        return(
            <div className="submit">
                {this.state.submitted?(
                    <div>
                        <h4> Success! Vehicle added!</h4>
                        <button className=" btn btn-success" onClick={this.newvehicle}>
                        Add
                        </button>
                        </div>
                ) : (
                    <div>
                        <div className="form-group">
                            <label htmlFor="id">id</label>
                            <input
                            type = "text"
                            className="form-control"
                            id = "id"
                            value = {this.state.id}
                            onChange={this.onChangeid}
                            name = "id"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="year">year</label>
                            <input
                            type = "text"
                            className="form-control"
                            id = "year"
                            value = {this.state.year}
                            onChange={this.onChangeyear}
                            name = "year"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="make">make</label>
                            <input
                            type = "text"
                            className="form-control"
                            id = "make"
                            value = {this.state.make}
                            onChange={this.onChangemake}
                            name = "make"
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="model">model</label>
                            <input
                            type = "text"
                            className="form-control"
                            id = "model"
                            value = {this.state.model}
                            onChange={this.onChangemodel}
                            name = "model"
                            />
                        </div>
                        <button onClick={this.savevehicle} className="btn btn-success">
                            Submit
                        </button>

                    </div>
        
                )}
            </div>
        )
    }
};
export default connect(null, { createvehicle })(Addvehicle);