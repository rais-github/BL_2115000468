import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsuranceManagement {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hashSet);
    }

    Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new HashSet<>();
        LocalDate now = LocalDate.now();
        for (Policy policy : hashSet) {
            if (ChronoUnit.DAYS.between(now, policy.expiryDate) <= 30) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    Set<Policy> getPoliciesByCoverageType(String coverageType) {
        Set<Policy> policiesByCoverageType = new HashSet<>();
        for (Policy policy : hashSet) {
            if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                policiesByCoverageType.add(policy);
            }
        }
        return policiesByCoverageType;
    }

    Set<Policy> getDuplicatePolicies() {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> policyNumbers = new HashSet<>();
        for (Policy policy : hashSet) {
            if (!policyNumbers.add(policy.policyNumber)) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        InsuranceManagement management = new InsuranceManagement();
        management.addPolicy(new Policy("P001", "John Doe", LocalDate.of(2023, 11, 15), "Health", 500.0));
        management.addPolicy(new Policy("P002", "Jane Smith", LocalDate.of(2023, 12, 1), "Auto", 300.0));
        management.addPolicy(new Policy("P003", "Alice Johnson", LocalDate.of(2023, 10, 25), "Home", 700.0));
        management.addPolicy(new Policy("P001", "John Doe", LocalDate.of(2023, 11, 15), "Health", 500.0));

        System.out.println("All Unique Policies: " + management.getAllUniquePolicies());
        System.out.println("Policies Expiring Soon: " + management.getPoliciesExpiringSoon());
        System.out.println("Policies with Coverage Type 'Health': " + management.getPoliciesByCoverageType("Health"));
        System.out.println("Duplicate Policies: " + management.getDuplicatePolicies());
    }
}