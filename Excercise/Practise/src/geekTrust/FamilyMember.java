package geekTrust;

import java.util.ArrayList;
import java.util.List;

public class FamilyMember {

	String name;
	Gender gender;

	FamilyMember father;
	FamilyMember mother;
	FamilyMember spouse;

	List<FamilyMember> children;

	public FamilyMember(String name, Gender gender, FamilyMember father, FamilyMember mother, FamilyMember spouse) {
		this.name = name;
		this.gender = gender;
		this.father = father;
		this.mother = mother;
		this.spouse = spouse;
		this.children = new ArrayList<>();
	}

	public void setSpouse(FamilyMember spouse) {
		this.spouse = spouse;
	}

	public void addChildren(FamilyMember children) {
		this.children.add(children);
	}

	public String findChildren(Gender gen) {
		StringBuilder ans = new StringBuilder("");
		for (FamilyMember child : this.children) {
			if (child.gender == gen)
				ans.append(child.name).append(" ");
		}
		return ans.toString().trim();
	}

	public String findSiblings() {
		StringBuilder ans = new StringBuilder("");
		if (this.mother != null) {
			for (FamilyMember sib : this.mother.children) {
				if (!this.name.equalsIgnoreCase(sib.name))
					ans.append(sib.name).append(" ");
			}
		}
		return ans.toString().trim();
	}

	public String searchChildren(Gender gender2, String name) {
		StringBuilder sb = new StringBuilder("");

		for (FamilyMember m : this.children) {
			if (!name.equals(m.name) && m.gender == gender) {
				sb.append(m.name).append(" ");
			}
		}

		return sb.toString().trim();
	}

	public String searchAuntOrUncle(Gender gender) {

		StringBuilder sb = new StringBuilder("");

		if (this.mother != null) {
			for (FamilyMember m : this.mother.children) {
				if (!this.name.equals(m.name) && m.gender == gender) {
					sb.append(m.name).append(" ");
				}
			}
		}

		return sb.toString().trim();
	}
}