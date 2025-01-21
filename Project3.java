import java.util.Scanner;


abstract class Account {
    double interestRate;
    double amount;

    abstract double calculateInterest();
}

class FDAccount extends Account {
    int noOfDays;
    int ageOfACHolder;

    FDAccount(double amount, int noOfDays, int ageOfACHolder) {
        this.amount = amount;
        this.noOfDays = noOfDays;
        this.ageOfACHolder = ageOfACHolder;
    }

    @Override
    double calculateInterest() {
        if (amount < 0 || noOfDays < 0 || ageOfACHolder < 0) {
            throw new IllegalArgumentException("Invalid input values.");
        }

        if (amount < 10000000) {
            if (noOfDays >= 7 && noOfDays <= 14) {
                interestRate = (ageOfACHolder >= 60) ? 5.00 : 4.50;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                interestRate = (ageOfACHolder >= 60) ? 5.25 : 4.75;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                interestRate = (ageOfACHolder >= 60) ? 6.00 : 5.50;
            } else if (noOfDays >= 46 && noOfDays <= 60) {
                interestRate = (ageOfACHolder >= 60) ? 7.50 : 7.00;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                interestRate = (ageOfACHolder >= 60) ? 8.00 : 7.50;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                interestRate = (ageOfACHolder >= 60) ? 8.50 : 8.00;
            }
        } else {
            if (noOfDays >= 7 && noOfDays <= 14) {
                interestRate = 6.50;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                interestRate = 6.75;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                interestRate = 6.75;
            } else if (noOfDays >= 46 && noOfDays <= 60) {
                interestRate = 8.00;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                interestRate = 8.50;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                interestRate = 10.00;
            }
        }
        return amount * interestRate / 100;
    }
}

class SBAccount extends Account {
    String accountType;

    SBAccount(double amount, String accountType) {
        this.amount = amount;
        this.accountType = accountType;
    }

    @Override
    double calculateInterest() {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid input values.");
        }

        if (accountType.equalsIgnoreCase("Normal")) {
            interestRate = 4.00;
        } else if (accountType.equalsIgnoreCase("NRI")) {
            interestRate = 6.00;
        }
        return amount * interestRate / 100;
    }
}

class RDAccount extends Account {
    int noOfMonths;
    double monthlyAmount;
    int ageOfACHolder;

    RDAccount(double monthlyAmount, int noOfMonths, int ageOfACHolder) {
        this.monthlyAmount = monthlyAmount;
        this.noOfMonths = noOfMonths;
        this.ageOfACHolder = ageOfACHolder;
    }

    @Override
    double calculateInterest() {
        if (monthlyAmount < 0 || noOfMonths < 0 || ageOfACHolder < 0) {
            throw new IllegalArgumentException("Invalid input values.");
        }

        if (noOfMonths == 6) {
            interestRate = (ageOfACHolder >= 60) ? 8.00 : 7.50;
        } else if (noOfMonths == 9) {
            interestRate = (ageOfACHolder >= 60) ? 8.25 : 7.75;
        } else if (noOfMonths == 12) {
            interestRate = (ageOfACHolder >= 60) ? 8.50 : 8.00;
        } else if (noOfMonths == 15) {
            interestRate = (ageOfACHolder >= 60) ? 8.75 : 8.25;
        } else if (noOfMonths == 18) {
            interestRate = (ageOfACHolder >= 60) ? 9.00 : 8.50;
        } else if (noOfMonths == 21) {
            interestRate = (ageOfACHolder >= 60) ? 9.25 : 8.75;
        }
        return monthlyAmount * noOfMonths * interestRate / 100;
    }
}

public class Project3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select the option:");
            System.out.println("1. Interest Calculator –SB");
            System.out.println("2. Interest Calculator –FD");
            System.out.println("3. Interest Calculator –RD");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Average amount in your account:");
                    double sbAmount = scanner.nextDouble();
                    System.out.println("Enter the type of account (Normal/NRI):");
                    String accountType = scanner.next();
                    SBAccount sbAccount = new SBAccount(sbAmount, accountType);
                    System.out.println("Interest gained: Rs. " + sbAccount.calculateInterest());
                    break;
                case 2:
                    System.out.println("Enter the FD amount:");
                    double fdAmount = scanner.nextDouble();
                    System.out.println("Enter the number of days:");
                    int noOfDays = scanner.nextInt();
                    System.out.println("Enter your age:");
                    int age = scanner.nextInt();
                    FDAccount fdAccount = new FDAccount(fdAmount, noOfDays, age);
                    System.out.println("Interest gained is: Rs. " + fdAccount.calculateInterest());
                    break;
                case 3:
                    System.out.println("Enter the monthly amount:");
                    double rdMonthlyAmount = scanner.nextDouble();
                    System.out.println("Enter the number of months:");
                    int noOfMonths = scanner.nextInt();
                    System.out.println("Enter your age:");
                    int rdAge = scanner.nextInt();
                    RDAccount rdAccount = new RDAccount(rdMonthlyAmount, noOfMonths, rdAge);
                    System.out.println("Interest gained is: Rs. " + rdAccount.calculateInterest());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}