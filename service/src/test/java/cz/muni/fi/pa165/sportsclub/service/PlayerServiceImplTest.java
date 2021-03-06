package cz.muni.fi.pa165.sportsclub.service;

import cz.muni.fi.pa165.sportsclub.EntityFactory;
import cz.muni.fi.pa165.sportsclub.ServiceConfig;
import cz.muni.fi.pa165.sportsclub.dao.PlayerDao;
import cz.muni.fi.pa165.sportsclub.dao.RosterEntryDao;
import cz.muni.fi.pa165.sportsclub.entity.Player;
import cz.muni.fi.pa165.sportsclub.entity.RosterEntry;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author 422636 Adam Krajcik
 */
@ContextConfiguration(classes = ServiceConfig.class)
public class PlayerServiceImplTest extends AbstractTestNGSpringContextTests {

    @Mock
    private PlayerDao playerDao;

    @Mock
    RosterEntryDao rosterEntryDao;

    @Inject
    @InjectMocks
    private PlayerService playerService;

    private Player player;
    private Player createdPlayer;
    private RosterEntry entry;

    @BeforeClass
    public void setUpClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        entry = EntityFactory.createRosterEntry();
        player = entry.getPlayer();
        createdPlayer = EntityFactory.createPlayer();
        createdPlayer.setId(1L);
        createdPlayer.addRosterEntry(entry);
    }

    @Test
    public void testCreatePlayer() throws Exception {
        playerService.createPlayer(player);
        verify(playerDao).create(player);
    }

    @Test
    public void testUpdatePlayer() throws Exception {
        playerService.updatePlayer(player);
        verify(playerDao).update(player);
    }

    @Test
    public void testDeletePlayer() throws Exception {
        when(playerDao.findById(createdPlayer.getId())).thenReturn(createdPlayer);
        playerService.deletePlayer(createdPlayer.getId());
        verify(playerDao).delete(createdPlayer);
        verify(rosterEntryDao).delete(entry);
    }

    @Test
    public void testFindById() throws Exception {
        when(playerDao.findById(1L)).thenReturn(createdPlayer);
        assertThat(playerService.findById(1L)).isEqualToComparingFieldByField(createdPlayer);
    }

    @Test
    public void testFindByEmail() throws Exception {
        when(playerDao.findByEmail(createdPlayer.getEmail())).thenReturn(createdPlayer);
        assertThat(playerService.findByEmail(createdPlayer.getEmail())).isEqualToComparingFieldByField(createdPlayer);
    }

    @Test
    public void testGetAll() throws Exception {
        when(playerDao.findAll()).thenReturn(Collections.singletonList(createdPlayer));
        assertThat(playerService.getAll()).isEqualTo(Collections.singletonList(createdPlayer));
    }
}