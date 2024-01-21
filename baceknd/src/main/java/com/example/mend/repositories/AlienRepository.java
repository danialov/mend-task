package com.example.mend.repositories;

import com.example.mend.models.Alien;
import com.example.mend.projections.AlienProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlienRepository extends JpaRepository<Alien, Long> {

    @Query(value = "SELECT 'Warrior' as type, w.id, w.name, w.commander_id AS commanderId, w.weapon, NULL as vehicle, com.name AS commanderName " +
            "FROM warrior w LEFT JOIN commander com ON w.commander_id = com.id " +
            "UNION " +
            "SELECT 'Commander' as type, c.id, c.name, c.commander_id AS commanderId, NULL as weapon, c.vehicle, cc.name AS commanderName " +
            "FROM commander c LEFT JOIN chief_commander cc ON c.commander_id = cc.id " +
            "UNION " +
            "SELECT 'ChiefCommander' as type, cc.id, cc.name, NULL as commanderId, NULL as weapon, cc.vehicle, NULL as commanderName " +
            "FROM chief_commander cc", nativeQuery = true)
    List<AlienProjection> findAllAliens();

}
