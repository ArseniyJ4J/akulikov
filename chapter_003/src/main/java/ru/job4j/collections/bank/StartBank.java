package ru.job4j.collections.bank;

import ru.job4j.collections.bank.exceptions.UncorrectAccount;
import ru.job4j.collections.bank.exceptions.UncorrectUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Class Класс StartBank.
 * @author Arseniy Kulkiov
 * @since 11.08.2017
 * @version 1
 */

public class StartBank {
    /**
     * поле класса clients - коллекция Map всех пар объектов User - Account с объектами User в качестве ключа.
     */
    private Map<User, List<Account>> clients = new HashMap<>();

    /**
     * Геттер для поля clients.
     * @return - возврат значения.
     */
    public Map<User, List<Account>> getClients() {
        return this.clients;
    }
    /**
     * Метод добавления пользователя.
     * @param user - пользователь.
     * @throws UncorrectUser - исключение в случае уже существующего пользователя, либо когда пользователь - null.
     */
    public void addUser(User user) throws UncorrectUser {

        if (user != null && !this.clients.containsKey(user)) {
            this.clients.put(user, new ArrayList<Account>());
        } else {
            throw new UncorrectUser("Such user already created, or equal null.");
        }
    }
    /**
     * Метод удаления пользователя.
     * @param user - пользователь.
     */
    public void deleteUser(User user) {
        clients.remove(user);
    }
    /**
     * Метод добавления счета у пользователя.
     * @param user - пользователь.
     * @param account - добавляемый счет.
     * @throws UncorrectUser - исключение на случай если пользователь - null или его нет в clients.
     * @throws UncorrectAccount - исключение на случай если счет - null.
     */
    public void addAccountToUser(User user, Account account) throws UncorrectUser, UncorrectAccount {
        if (user != null && this.clients.containsKey(user)) {
            if (account != null) {
                this.clients.get(user).add(account);
            } else {
                throw new UncorrectAccount("Such account is equal null.");
            }
        } else {
            throw new UncorrectUser("Such user not available, or equal null.");
        }
    }
    /**
     * Метод удаления счета пользователя.
     * @param user - пользователь.
     * @param account - счет.
     */
    public void deleteAccountFromUser(User user, Account account) {
        this.clients.get(user).remove(account);
    }

    /**
     * Метод возвращающий все счета пользователя в виде list.
     * @param user - пользователь.
     * @return - возврат значения.
     */
    public List<Account> getUserAccount(User user) {
        return this.clients.get(user);
    }
    /**
     * Метод переводящий сумму со счета на счет.
     * @param srcUser - пользователь от которого переводим.
     * @param srcAccount - счет с которого переводим.
     * @param dstUser - пользователь которому переводим.
     * @param dstAccount - счет на который перерводим.
     * @param amount - сумма для перевода.
     * @return - возврат true, если перевод выполнен, либо false если не выполнен, т.к. недостаточно средств на счету, либо указанный счет не найден.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        if (clients.containsKey(srcUser) && clients.containsKey(dstUser)) {
            if (clients.get(srcUser).contains(srcAccount) && clients.get(dstUser).contains(dstAccount)) {
                if (clients.get(srcUser).get(clients.get(srcUser).indexOf(srcAccount)).getValue() >= amount) {
                    srcAccount.setValue(srcAccount.getValue() - amount);
                    dstAccount.setValue(dstAccount.getValue() + amount);
                    result = true;
                }
            }
        }
        return result;
    }
}
