package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {

        MyDatabase db = new MyDatabase();
        ExpenseRepository test = new ExpenseRepository(db);
        assertEquals(Collections.emptyList(),test.getExpenses());

        IFancyDatabase mocek =  mock(IFancyDatabase.class);
        when(mocek.queryAll()).thenReturn(Collections.emptyList());

        MyDatabase db2 = mock(MyDatabase.class);
        ExpenseRepository test2 = new ExpenseRepository(db2);
        test2.loadExpenses();
        InOrder inOrder = inOrder(db2);
        inOrder.verify(db2).connect();
        inOrder.verify(db2).queryAll();
        inOrder.verify(db2).close();
        assertEquals(Collections.emptyList(), test2.getExpenses());
    }
    @Test
    void loadExpenses2() {
            MyDatabase db = new MyDatabase();
            ExpenseRepository test = new ExpenseRepository(db);
            assertEquals(Collections.emptyList(),test.getExpenses());

            IFancyDatabase mocek =  mock(IFancyDatabase.class);
            when(mocek.queryAll()).thenReturn(Collections.emptyList());

            MyDatabase db2 = mock(MyDatabase.class);
            ExpenseRepository test2 = new ExpenseRepository(db2);
            test2.loadExpenses();
            InOrder inOrder = inOrder(db2);
            inOrder.verify(db2).connect();
            inOrder.verify(db2).queryAll();
            inOrder.verify(db2).close();
            assertEquals(Collections.emptyList(), test2.getExpenses());

    }

    @Test
    void saveExpenses() {
        MyDatabase db = new MyDatabase();
        ExpenseRepository test = new ExpenseRepository(db);
        assertEquals(Collections.emptyList(),test.getExpenses());

        IFancyDatabase mocek =  mock(IFancyDatabase.class);
        when(mocek.queryAll()).thenReturn(Collections.emptyList());

        MyDatabase db2 = mock(MyDatabase.class);
        ExpenseRepository test2 = new ExpenseRepository(db2);


        test2.loadExpenses();
        InOrder inOrder = inOrder(db2);
        inOrder.verify(db2).connect();
        inOrder.verify(db2).queryAll();
        inOrder.verify(db2).close();
        assertEquals(Collections.emptyList(), test2.getExpenses());
        Expense ex = new Expense();
        Expense ex2 = new Expense();
        Expense ex3 = new Expense();
        Expense ex4 = new Expense();
        Expense ex5 = new Expense();
        test2.addExpense(ex);
        test2.addExpense(ex2);
        test2.addExpense(ex3);
        test2.addExpense(ex4);
        test2.addExpense(ex5);

        test2.saveExpenses();
        verify(db2, times(5)).persist(any(Expense.class));

    }
}
