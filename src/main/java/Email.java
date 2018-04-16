public class Email {

    private Employee employee;
    private String password;
    private String adress;
    private int inboxCapacity = 500;
    private String alternativeEmail = "";

    private static final String COMPANY_SUFFIX = "blueecho.com";
    private static final int DEFAULT_PASSWORD_LENGTH = 8;

    // POSSIBLES CHARACTERS FOR THE AUTO-GENERATED RANDOM PASSWORD
    private static final String PASSWORD_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public Email(Employee employee) {
        this.employee = employee;
        this.password = randomPassword(DEFAULT_PASSWORD_LENGTH);
        this.adress = createAdress();
    }

    private String createAdress() {
        String firstName = employee.getFirstName().replaceAll("\\s", "").toLowerCase();
        String lastName = employee.getLastName().replaceAll("\\s", "").toLowerCase();
        String department = employee.getDepartment().toLowerCase();

        adress = firstName + "." + lastName + "@" + department + "_" + COMPANY_SUFFIX;

        return adress;
    }

    private String randomPassword(int length) {
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            /*
            DON'T TRY TO CAST Math.random() TO INT ALONE BECAUSE IT WILL BE ALWAYS ROUNDED TO 0
            SO THE PASSWORD RESULT ENDS UP BEING "aaaaa..." IF YOU CHANGE THE ALGORITHM DON'T
            FORGET TO CAST IT SURROUNDED BY "()" BECAUSE IT WILL MELT YOUR BRAIN.
             */
            int random = (int) (Math.random() * PASSWORD_SET.length());
            password[i] = PASSWORD_SET.charAt(random);
        }

        return new String(password);
    }

    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getAdress() { return adress; }

    public String printInfo() {
        return "Employee: " + employee.getFirstName() + " " + employee.getLastName() +
                "\nEmail adress: " + adress +
                "\nPassword: " + password +
                "\nAlternative Email: " + inboxCapacity;
    }

}
