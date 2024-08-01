package com.example.libadmin;

import java.util.ArrayList;
import java.util.List;

public class LoanOperations {
    private List<Loan> loanList;
    private List<Book> loanBookList;
    public LoanOperations() {
        loanList = new ArrayList<>();
        loanBookList = new ArrayList<>();
    }

    public void addLoan(Loan loan) {
        loanList.add(loan);
    }

    public void addLoanBook(Book book){loanBookList.add(book);}

    public void removeLoan(Loan loan) {
        loanList.remove(loan);
    }

    public Book SearchLoanBook(int id){
        for (Book i : loanBookList){
            if (i.getBookID() == id) {
                return i;
            }
        }return null;

    }

    public List<Loan> getLoanList() {
        return loanList;
    }
}
