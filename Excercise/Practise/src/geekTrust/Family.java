package geekTrust;

import java.util.ArrayList;
import java.util.List;

public class Family implements MessageConstants, RelationConstants {

	private static String MALE = "Male";
	private FamilyMember head;

	public void addFamilyHead(String name, String gender) {
		Gender gen = null;
		if (gender.equalsIgnoreCase(MALE)) {
			gen = Gender.MALE;
		} else {
			gen = Gender.FEMALE;
		}
		this.head = new FamilyMember(name, gen, null, null, null);
	}

	public void addSpouse(String memberName, String spouseName, String gender) {
		// to add spouse first I have to find the Member. In sort I have to do Traversal
		// on a tree to find the member.

		FamilyMember member = doFindMember(head, memberName);
		if (member != null && member.spouse == null) {// before setting spouse check weather present or not.
			Gender gen = gender.equalsIgnoreCase(MALE) ? Gender.MALE : Gender.FEMALE;
			FamilyMember spouse = new FamilyMember(spouseName, gen, null, null, member);
			member.setSpouse(spouse);
		}
	}

	public String addChild(String motherName, String childName, String gender) {
		FamilyMember mother = doFindMember(head, motherName);
		if (mother == null) {
			// person not found;
			return PERSON_NOT_FOUND;
		}
		if (childName == null || childName.isEmpty() || gender == null || gender.isEmpty())
			return CHILD_ADDITION_FAILED;
		if (mother.gender == Gender.FEMALE) {
			Gender childGen = gender.equalsIgnoreCase(MALE) ? Gender.MALE : Gender.FEMALE;
			FamilyMember child = new FamilyMember(childName, childGen, mother.spouse, mother, null);
			mother.addChildren(child);
			if(mother.spouse != null) {
				mother.spouse.addChildren(child);
			}
			return CHILD_ADDITION_SUCCEEDED;
		} else {
			return CHILD_ADDITION_FAILED;
		}
	}

	private FamilyMember doFindMember(FamilyMember head, String memberName) {

		if (head == null || memberName == null)
			return null;

		if (head.name.equalsIgnoreCase(memberName)) {// Head is member
			return head;
		} else if (head.spouse != null && head.spouse.name.equalsIgnoreCase(memberName)) {
			return head.spouse;
		}

		// do traverse on Children of member if exists.
		List<FamilyMember> children = new ArrayList<>();;
		if (head.gender == Gender.MALE) {
			children = head.children;
		} else if(head.spouse != null){
			children = head.spouse.children;
		}
		if (children != null && children.size() > 0) {
			for (FamilyMember mem : children) {
				FamilyMember member = doFindMember(mem, memberName);
				if (member != null) {// we found a member so no need to traverse further.
					return member;
				}
			}
		}
		return null;
	}

	public String getRelationShip(String memberName, String relation) {

		String relations;
		FamilyMember member = doFindMember(head, memberName);

		if (member == null) {
			relations = PERSON_NOT_FOUND;
		} else if (relation == null || relation.isEmpty()) {
			relations = PROVIDE_VALID_RELATION;
		} else {
			relations = getRelationForFamilyMember(member, relation);
		}
		return relations;
	}

	private String getRelationForFamilyMember(FamilyMember member, String relation) {

		String relations = null;

		switch (relation) {
		case SON:
			relations = member.findChildren(Gender.MALE);
			break;
		case DAUGHTER:
			relations = member.findChildren(Gender.FEMALE);
			break;
		case SIBLINGS:
			relations = member.findSiblings();
			break;

		case BROTHER_IN_LAW:
			relations = findInLaw(member, Gender.MALE);
			break;

		case SISTER_IN_LAW:
			relations = findInLaw(member, Gender.FEMALE);
			break;

		case PATERNAL_AUNT:
			if (member.father != null)
				 relations = member.father.searchAuntOrUncle(Gender.FEMALE);
			break;

		case PATERNAL_UNCLE:
			 if (member.father != null)
				 relations = member.father.searchAuntOrUncle(Gender.MALE);
			break;

		case MATERNAL_AUNT:
			 if (member.mother != null)
				 relations = member.mother.searchAuntOrUncle(Gender.FEMALE);
			break;

		case MATERNAL_UNCLE:
			 if (member.mother != null)
				 relations = member.mother.searchAuntOrUncle(Gender.MALE);
			break;

		default:
			relations = NOT_YET_IMPLEMENTED;
			break;
		}
		relations = relations.equals("") ? "" : relations;
		return relations;
	}

	private String findInLaw(FamilyMember member, Gender gen) {
		String name = member.name;
		StringBuilder sb = new StringBuilder("");
		String res = "";

		// find spouse mother children
		if (member.spouse != null && member.spouse.mother != null) {
			res = member.spouse.mother.searchChildren(gen, member.spouse.name);
		}
		sb.append(res);

		// find mother children
		res = "";
		if (member.mother != null) {
			res = member.mother.searchChildren(gen, name);
		}
		sb.append(res);

		return sb.toString().trim();
	}
}
