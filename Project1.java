public class Project1 {
    public static void main(String[] args) {
        
        String[][] employees = {
            {"1001", "Ashish", "01/04/2009", "e", "R&D", "20000", "8000", "3000"},
            {"1002", "Sushma", "23/08/2012", "c", "PM", "30000", "12000", "9000"},
            {"1003", "Rahul", "12/11/2008", "k", "Acct", "10000", "8000", "1000"},
            {"1004", "Chahat", "29/01/2013", "r", "Front Desk", "12000", "6000", "2000"},
            {"1005", "Ranjan", "16/07/2005", "m", "Engg", "50000", "20000", "20000"},
            {"1006", "Suman", "01/01/2000", "e", "Manufacturing", "23000", "9000", "4400"},
            {"1007", "Tanmay", "12/06/2006", "c", "PM", "29000", "12000", "10000"}
        };
        if (args.length == 0) {
            System.out.println("Please provide an employee ID.");
            return;
        }
        // String empId = args[0];
        // for (String[] employee : employees) {
        //     if (employee[0].equals(empId)) {
        //         found = true;
        //         String empName = employee[1];
        //         String department = employee[4];
        //         String desigCode = employee[3];

        String empId = args[0];
        boolean found = false;
        for (String[] employee : employees) {
            if (employee[0].equals(empId)) {
                found = true;
                String empName = employee[1];
                String department = employee[4];
                String desigCode = employee[3];
                int basic = Integer.parseInt(employee[5]);
                int hra = Integer.parseInt(employee[6]);
                int it = Integer.parseInt(employee[7]);

                String designation = "";
                int da = 0;

                switch (desigCode) {
                    case "e":
                        designation = "Engineer";
                        da = 20000;
                        break;
                    case "c":
                        designation = "Consultant";
                        da = 32000;
                        break;
                    case "k":
                        designation = "Clerk";
                        da = 12000;
                        break;
                    case "r":
                        designation = "Receptionist";
                        da = 15000;
                        break;
                    case "m":
                        designation = "Manager";
                        da = 40000;
                        break;
                    default:
                        designation = "Unknown";
                        da = 0;
                        break;
                }

                int netSalary = basic + hra + da - it;

                System.out.println("Emp No   Emp-Name   Department   Designation   Salary");
                System.out.println(empId + "   " + empName + "   " + department + "   " + designation + "   " + netSalary);
                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid: " + empId);
        }
    }
}