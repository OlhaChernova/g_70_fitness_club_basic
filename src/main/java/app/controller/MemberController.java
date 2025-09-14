package app.controller;

import app.domain.Member;
import app.service.MemberService;

import java.util.List;

public class MemberController {

    private final MemberService service = new MemberService();

    public Member save(String name) {
        Member member = new Member(name);
        return service.save(member);
    }

    public List<Member> getAll() {
        return service.getAllActiveMembers();
    }

    public Member getById(Long id) {
        return service.getActiveMemberById(id);
    }

    public void deleteById(Long id) {
        service.deleteById(id);
    }

    public void deleteByName(String name) {
        service.deleteByName(name);
    }

    public void restoreById(Long id) {
        service.restoreById(id);
    }

    public void restoreByName(String name) {
        service.restoreByName(name);
    }

    public int getMembersNumber() {
        return service.getActiveMembersNumber();
    }
}

