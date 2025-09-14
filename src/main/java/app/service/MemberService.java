package app.service;

import app.domain.Member;
import app.exceptions.MemberRestoreException;
import app.exceptions.MemberSaveException;
import app.exceptions.MemeberNotFoundException;
import app.repository.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository repository = new MemberRepository();
    private static MemberService instance;

    public MemberService() {
    }

    public static MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();
        }
        return instance;
    }

    public Member save(Member member) {
        if (member == null) {
            throw new MemberSaveException("Пользователь не может быть пустым");
        }

        String name = member.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new MemberSaveException("Имя не может быть пустым");
        }

        member.setActive(true);
        return repository.save(member);
    }

    public List<Member> getAllActiveMembers() {
        return repository.findAll()
                .stream()
                .filter(Member::isActive)
                .toList();
    }

    public Member getActiveMemberById(Long id) {
        Member member = repository.findById(id);

        if (member == null || !member.isActive()) {
            throw new MemeberNotFoundException(id);
        }
        return member;
    }

    public void deleteById(Long id) {
        Member member = getActiveMemberById(id);
        member.setActive(false);
    }

    public void deleteByName(String name) {
        getAllActiveMembers()
                .stream()
                .filter(x -> x.getName().equals(name))
                .forEach(x -> x.setActive(false));
    }

    public void restoreById(Long id) {
        Member member = repository.findById(id);

        if (member == null) {
            throw new MemeberNotFoundException(id);
        }
        member.setActive(true);
    }

    public void restoreByName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new MemberRestoreException("Имя не может быть пустым");
        }
        Member member = repository.findByName(name);
        member.setActive(true);
    }

    public  int getActiveMembersNumber() {
        return getAllActiveMembers().size();
    }
}
