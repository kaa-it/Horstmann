package com.akruglov.chapter02;

import java.util.ArrayList;

/**
 * Created by akruglov on 26.03.17.
 */
public class Network {

    public class Member {
        private String name;
        private ArrayList<Member> friends;

        public Member(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }

        public void leave() {
            members.remove(this);
        }
    }

    private ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public static void main(String[] args) {
        Network myFace = new Network();
        Network.Member fred = myFace.enroll("fred");

        fred.leave();
    }
}
