# PetClinic Domain Model

This is a fork of the Spring PetClinic application.

Since the purpose of the original Spring PetClinic application is to demonstrate capabilities of the
Spring framework, the focus is primarily on the infrastructure - the HTTP RESTful interface and DB persistence capabilities.
The domain model serves only a supporting role and is relatively anemic and CRUD-like, focusing on the data over the business processes and user intentions behind the actions.

In contrast, the goal of this fork of the Spring PetClinic application is to demonstrate the application of
Domain Driven Design techniques in order to develop a well-defined and encapsuled core domain model
independent of any infrastructure concerns. As such, I will have to take some liberties in my understanding
of the PetClinic domain in order to fabricate a meaningful domain model and set of use cases.

I will attempt to keep the domain model as pure and free of infrastructure concerns as possibly, relying only on
contemporary Java (17+) constructs.

For simplicity, I will use the ClinicService facade of the Spring-PetClinic-REST fork as the reference point to reverse-engineer
a PetClinic domain model. This facade best encapsulates the business-logic of the original PetClinic application.

```java
public interface ClinicService {

	Pet findPetById(int id) throws DataAccessException;
	Collection<Pet> findAllPets() throws DataAccessException;
	void savePet(Pet pet) throws DataAccessException;
	void deletePet(Pet pet) throws DataAccessException;

	Collection<Visit> findVisitsByPetId(int petId);
	Visit findVisitById(int visitId) throws DataAccessException;
	Collection<Visit> findAllVisits() throws DataAccessException;
	void saveVisit(Visit visit) throws DataAccessException;
	void deleteVisit(Visit visit) throws DataAccessException;
	
	Vet findVetById(int id) throws DataAccessException;
	Collection<Vet> findVets() throws DataAccessException;
	Collection<Vet> findAllVets() throws DataAccessException;
	void saveVet(Vet vet) throws DataAccessException;
	void deleteVet(Vet vet) throws DataAccessException;
	
	Owner findOwnerById(int id) throws DataAccessException;
	Collection<Owner> findAllOwners() throws DataAccessException;
	void saveOwner(Owner owner) throws DataAccessException;
	void deleteOwner(Owner owner) throws DataAccessException;
	Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException;

	PetType findPetTypeById(int petTypeId);
	Collection<PetType> findAllPetTypes() throws DataAccessException;
	Collection<PetType> findPetTypes() throws DataAccessException;
	void savePetType(PetType petType) throws DataAccessException;
	void deletePetType(PetType petType) throws DataAccessException;
	
	Specialty findSpecialtyById(int specialtyId);
	Collection<Specialty> findAllSpecialties() throws DataAccessException;
	void saveSpecialty(Specialty specialty) throws DataAccessException;
	void deleteSpecialty(Specialty specialty) throws DataAccessException;

}
```

You'll notice all of the operations follow a consistent CRUD-like pattern:

- find (Read)
- save (Create/Update)
- delete (Delete)

CRUD is a generic pattern that treats a domain as simply a set of data forms.
It's biggest drawback is that it fails to capture the user intent behind any of these actions.
There's no way, for example, to distinguish whether a Vet is being deleted because they have
retired from practice, are deceased, or because they have simply relocated to another clinic.
Therefore, it allows encapsulation of only basic policies and consistency that are applicable
to these generic operations.
A Vet that has relocated, or even retired, may subsequently return to practice at a clinic. Obviously,
this is not possible for a deceased Vet. The semantics of these use case scenarios are completed lost
behind a common deleteVet operation, which treats them all through the same lens of dealing with the data
rather than the business intent.

A proper domain model, however, will define more prescriptive operations that reflect the business processes
and language of the domain.

## Entities

We can easily identify the following domain model entities from the reference application, based on the fact that
they all rely on a unique identifier:

- Pet
- PetType
- Owner
- Vet
- Specialty

## Domain Services

