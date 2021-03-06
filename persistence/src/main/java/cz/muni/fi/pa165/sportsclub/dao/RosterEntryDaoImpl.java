package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.RosterEntry;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of RosterEntryDao
 *
 * @author 445403 Kristián Katanik
 */

@Repository
@Transactional
public class RosterEntryDaoImpl implements RosterEntryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(RosterEntry rosterEntry) {
        if (rosterEntry == null) {
            throw new IllegalArgumentException("RosterEntry cannot be null");
        }
        em.persist(rosterEntry);
    }

    @Override
    public RosterEntry update(RosterEntry rosterEntry) {
        if (rosterEntry == null) {
            throw new IllegalArgumentException("RosterEntry cannot be null");
        }
        return em.merge(rosterEntry);
    }

    @Override
    public void delete(RosterEntry rosterEntry) {
        if (rosterEntry == null) {
            throw new IllegalArgumentException("RosterEntry cannot be null");
        }
        em.remove(em.merge(rosterEntry));
    }

    @Override
    public RosterEntry findById(Long id) {
        return em.find(RosterEntry.class, id);
    }

    @Override
    public List<RosterEntry> findAll() {
        return em.createQuery("SELECT re FROM RosterEntry re", RosterEntry.class).getResultList();
    }
}
