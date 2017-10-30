package ru.job4j.multithreading.monitore;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * UserStorage Class.
 * @author Arseniy Kulikov.
 * @since 30.10.2017
 * @version 1.
 */
@ThreadSafe
public class UserStorage {

    /**
     * Class field. Conteiner for Users.
     */
    Map<Integer, User> container = new HashMap<>();

    /**
     * Add method.
     * @param user - user for add.
     */
    public synchronized void add(User user) {
        this.container.put(user.getId(), user);
    }

    /**
     * Update method.
     * @param user - user for update.
     */
    public synchronized void update(User user) {
          this.container.replace(user.getId(), this.container.get(user.getId()), user);
    }

    /**
     * Delete method.
     * @param user - user for delete.
     */
    public synchronized void delete(User user) {
        this.container.remove(user.getId());
        System.out.println("");
    }

    /**
     * Transfer method.
     * @param fromId - id form.
     * @param toId - id to.
     * @param amount - money.
     */
    public synchronized void transfer(int fromId, int toId, int amount) {
        User from = this.container.get(fromId);
        User to = this.container.get(toId);
        from.setAmount(from.getAmount() - amount);
        to.setAmount(to.getAmount() + amount);
    }
}
