package ru.job4j.collections.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Class Класс SortBankTest.
 * @author Arseniy Kulkiov
 * @since 14.08.2017
 * @version 1
 */
public class StartBankTest {
    /**
     * Test.
     */
    @Test
    public void addUserTest() {
        StartBank sb = new StartBank();
        User user = new User("Ivan", 001);
        sb.addUser(user);
        boolean result = sb.getClients().containsKey(user);
        assertThat(result, is(true));
    }
    /**
     * Test.
     */
    @Test
    public void deleteUserTest() {
        StartBank sb = new StartBank();
        User user = new User("Ivan", 001);
        sb.addUser(user);
        sb.deleteUser(user);
        boolean result = sb.getClients().containsKey(user);
        assertThat(result, is(false));
    }
    /**
     * Test.
     */
    @Test
    public void addAccountToUserTest() {
        StartBank sb = new StartBank();
        Account account = new Account(99.2, 100);
        User user = new User("Ivan", 001);
        sb.addUser(user);
        sb.addAccountToUser(user, account);
        boolean result = sb.getUserAccount(user).contains(account);
        assertThat(result, is(true));
    }
    /**
     * Test.
     */
    @Test
    public void deleteAccountFromUserTest() {
        StartBank sb = new StartBank();
        Account account1 = new Account(99.2, 100);
        Account account2 = new Account(37.5, 101);
        User user = new User("Ivan", 001);
        sb.addUser(user);
        sb.addAccountToUser(user, account1);
        sb.addAccountToUser(user, account2);
        sb.deleteAccountFromUser(user, account2);
        boolean result = sb.getUserAccount(user).contains(account2);
        assertThat(result, is(false));
    }
    /**
     * Test.
     */
    @Test
    public void getUserAccountTest() {
        StartBank sb = new StartBank();
        Account account = new Account(99.2, 100);
        User user = new User("Ivan", 001);
        User user1 = new User("Sergey", 002);
        sb.addUser(user);
        sb.addUser(user1);
        sb.addAccountToUser(user, account);
        boolean result = sb.getUserAccount(user).contains(account) && sb.getUserAccount(user1).isEmpty();
        assertThat(result, is(true));
    }
    /**
     * Test.
     */
    @Test
    public void transferMoneyTest() {
        StartBank sb = new StartBank();
        Account srcAccount = new Account(99, 100);
        Account dstAccount = new Account(23, 100);
        User srcUser = new User("Ivan", 001);
        User dstUser = new User("Sergey", 002);
        sb.addUser(srcUser);
        sb.addUser(dstUser);
        sb.addAccountToUser(srcUser, srcAccount);
        sb.addAccountToUser(dstUser, dstAccount);
        boolean transferResultTrue = sb.transferMoney(srcUser, srcAccount, dstUser, dstAccount, 50);
        boolean transferResultFalse = sb.transferMoney(srcUser, srcAccount, dstUser, dstAccount, 100);
        boolean result = sb.getUserAccount(srcUser).get(0).getValue() == 49;
        assertThat(transferResultTrue, is(true));
        assertThat(transferResultFalse, is(false));
        assertThat(result, is(true));
    }
    /**
     * Test.
     */
    @Test
    public void transferMoneyTest2() {
        StartBank sb = new StartBank();
        Account srcAccount = new Account(99, 100);
        Account dstAccount = new Account(23, 100);
        User srcUser = new User("Ivan", 001);
        sb.addUser(srcUser);
        sb.addAccountToUser(srcUser, srcAccount);
        sb.addAccountToUser(srcUser, dstAccount);
        boolean transferResultTrue = sb.transferMoney(srcUser, srcAccount, srcUser, dstAccount, 50);
        boolean transferResultFalse = sb.transferMoney(srcUser, srcAccount, srcUser, dstAccount, 100);
        boolean result = sb.getUserAccount(srcUser).get(0).getValue() == 49;
        assertThat(transferResultTrue, is(true));
        assertThat(transferResultFalse, is(false));
        assertThat(result, is(true));
    }
}
