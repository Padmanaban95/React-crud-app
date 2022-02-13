package com.balaji.vehicles.demo.test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.balaji.vehicles.demo.model.vehicle;
import com.balaji.vehicles.demo.repo.vehiclerepo;
@RunWith(SpringRunner.class)
@DataJpaTest
public class vehicletest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    vehiclerepo vehrep;
    
    @Test
    public void if_repo_is_empty(){
        Iterable <vehicle> vehicles = vehrep.findAll();
        assertThat(vehicles).isEmpty(); 
    }
    @Test
    public void create_vehicle() {

        vehicle veh  = vehrep.save(new vehicle(8, 2022, "iron 882", "cruiser"));
        assertThat(veh).hasFieldOrPropertyWithValue("id", "8");
        assertThat(veh).hasFieldOrPropertyWithValue("year", "2022");
        assertThat(veh).hasFieldOrPropertyWithValue("make", "iron882");
        assertThat(veh).hasFieldOrPropertyWithValue("model", "cruiser");
    }
    @Test
    public void find_all_vehicles() {
        vehicle veh2 = new vehicle(9, 2019, "xyz", "xyz");
        entityManager.persist(veh2);
        vehicle veh3 = new vehicle(10, 2018, "abc", "def") ;
        entityManager.persist(veh3);
        Iterable<vehicle> vehicles = vehrep.findAll();
        assertThat(vehicles).hasSize(2).contains(veh2, veh3);
    }
    @Test
    public void find_vehicle_by_id() {
        vehicle veh4 = new vehicle(11 , 2017, "xys", "lop");
        entityManager.persist(veh4);
        vehicle newvehi = vehrep.findById(veh4.getId()).get();
        assertThat(newvehi).isEqualTo(veh4);
    }
    @Test
    public void delete_vehicle_by_id(){
        vehicle veh5 = new vehicle(12, 2016, "acd", "iop");
        entityManager.persist(veh5);
        vehrep.deleteById(veh5.getId());
        Iterable<vehicle> vehicles = vehrep.findAll();
        assertThat(vehicles).contains(veh5);
    }








}
