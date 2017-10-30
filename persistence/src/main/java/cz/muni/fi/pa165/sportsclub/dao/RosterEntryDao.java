package cz.muni.fi.pa165.sportsclub.dao;


import cz.muni.fi.pa165.sportsclub.entity.RosterEntry;

import java.util.List;

/**
 * DAO interface for entity RosterEntry
 *
 * @author 445403 Kristán Katanik
 */
public interface RosterEntryDao {

    /**
     * Creates a new RosterEntry and stores into database.
     *
     * @param rosterEntry to be created.
     */
    void create(RosterEntry rosterEntry);

    /**
     * Updates attributes of RosterEntry.
     *
     * @param rosterEntry to be updated.
     * @return updated RosterEntry.
     */
    RosterEntry update(RosterEntry rosterEntry);

    /**
     * Deletes RosterEntry from database.
     *
     * @param rosterEntry to be deleted.
     */
    void delete(RosterEntry rosterEntry);

    /**
     * Find specific RosterEntry by its ID
     *
     * @param id of RosterEntry
     * @return specific RosterEntry
     */
    RosterEntry findById(Long id);

    /**
     * List all RosterEntries
     *
     * @return list of all RosterEntries.
     */
    List<RosterEntry> findAll();

}
