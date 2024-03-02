package dao;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import bean.User;
import lombok.experimental.FieldDefaults;
import org.hibernate.*;
import util.Util;

import java.util.List;
import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserDaoHibernateImpl implements UserDao {

    SessionFactory sessionFactory = Util.getHibernateConnection();

    @Override
//    @SneakyThrows
    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user (id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(45), lastName VARCHAR(45), age TINYINT(3) )";
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
//    @SneakyThrows
    public void dropUserTable() {
        String sql = "DROP TABLE IF EXISTS user";
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(new User(name, lastName, age));
            transaction.commit();
            System.out.println("User с именем – " + name + " " + lastName + " добавлен в базу данных");
        } catch (HibernateException e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (HibernateException e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            users = session.createQuery("from User", User.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    @SneakyThrows
    public void clearUserTable() {
        String sql = "TRUNCATE TABLE user";
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
