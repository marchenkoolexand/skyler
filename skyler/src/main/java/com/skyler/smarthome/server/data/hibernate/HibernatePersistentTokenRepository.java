package com.skyler.smarthome.server.data.hibernate;

import com.skyler.smarthome.server.model.PersistentLogin;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Repository("tokenRepositoryDao")
@Transactional
public class HibernatePersistentTokenRepository implements PersistentTokenRepository {

    final static Logger logger = Logger.getLogger(HibernatePersistentTokenRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setEmail(token.getUsername());
        persistentLogin.setSeries(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setS_last_used(token.getDate());
        Session session = sessionFactory.openSession();
        session.persist(persistentLogin);

    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        try {
            Criteria crit = sessionFactory.getCurrentSession().createCriteria(PersistentLogin.class);
            crit.add(Restrictions.eq("series", seriesId));
            PersistentLogin persistentLogin = (PersistentLogin) crit.uniqueResult();
            return new PersistentRememberMeToken(persistentLogin.getEmail(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getS_last_used());
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public void removeUserTokens(String email) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersistentLogin.class);
        criteria.add(Restrictions.eq("email", email));
        PersistentLogin persistentLogin = (PersistentLogin) criteria.uniqueResult();
        if (persistentLogin != null) {
            Session session = sessionFactory.openSession();
            session.delete(persistentLogin);
            session.close();
        }
    }

    @Override
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        PersistentLogin persistentLogin =  (PersistentLogin) sessionFactory.getCurrentSession().get(PersistentLogin.class ,seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setS_last_used(lastUsed);
        Session session = sessionFactory.openSession();
        session.update(persistentLogin);
        session.close();
    }
}