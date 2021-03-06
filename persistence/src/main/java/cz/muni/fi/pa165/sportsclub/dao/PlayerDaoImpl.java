package cz.muni.fi.pa165.sportsclub.dao;


import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.Team;
import cz.muni.fi.pa165.sportsclub.enums.AgeGroup;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;


/**
 * Implementation of PlayerDAO
 *
 * @author 422636 Adam Krajcik
 */
@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void create(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        em.persist(player);
    }

    @Override
    public void update(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        em.merge(player);
    }

    @Override
    public void delete(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
            em.remove(em.merge(player));
    }

    @Override
    public Player findById(Long id) {
        return em.find(Player.class, id);
    }

    @Override
    public List<Player> findAll() {
        return em.createQuery("SELECT p FROM Player p", Player.class).getResultList();
    }

    @Override
    public List<Player> findByBirthDate(Date from, Date to) {
        return em.createQuery("SELECT p FROM" +
                " Player p" +
                " WHERE p.dateOfBirth >= :from" +
                " AND p.dateOfBirth <= :to", Player.class)
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
    }

    @Override
    public Player findByEmail(String email) {
        return em.createQuery("SELECT p FROM Player p WHERE p.email = :email", Player.class)
                .setParameter("email", email).getSingleResult();
    }

    @Override
    public List<Team> findTeamsByPlayer(Player player) {
        return em.createQuery("SELECT t FROM Team t JOIN t.rosterEntries r WHERE r.player = :player", Team.class)
                .setParameter("player", player).getResultList();
    }
}
