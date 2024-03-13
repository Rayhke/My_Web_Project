package com.DB_Test;

import com.DB_Test.JDBC.MemberDAO;
import com.DB_Test.JDBC.MemberDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JDBC_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mode;
        String set;

        while(true) {
            System.out.println("=========================================================\n");
            System.out.println("[1:삽입], [2:조회], [3:수정], [4:삭제], [5:전체조회], [6:종료]");
            mode = Integer.parseInt(br.readLine());

            if (mode == 1) {

                MemberDTO member = new MemberDTO();

                while(true) {
                    System.out.println("\n[정보를 순서대로 입력 하십시오.]\n");

                    while(true) {
                        System.out.print("\n아이디 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setId(set); break;
                        } else {
                            System.out.println("[잘못된 입력]");
                        }
                    }
                    while(true) {
                        System.out.print("\n비밀번호 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setPwd(set); break;
                        } else {
                            System.out.println("[잘못된 입력]");
                        }
                    }
                    while(true) {
                        System.out.print("\n닉네임 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setNickname(set); break;
                        } else {
                            System.out.println("[잘못된 입력]");
                        }
                    }
                    while(true) {
                        System.out.print("\n전화번호 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setPhone(set); break;
                        } else {
                            System.out.println("[잘못된 입력]");
                        }
                    }
                    while(true) {
                        System.out.print("\n이메일 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setEmail(set); break;
                        } else {
                            System.out.println("[잘못된 입력]");
                        }
                    }

                    System.out.println("\n" + member.toString() + "\n1을 입력하면 삽입을 진행하고, 아니라면 재입력을 진행 합니다.");
                    mode = Integer.parseInt(br.readLine());

                    if (mode == 1) {
                        MemberDAO DAO = new MemberDAO();
                        DAO.insert(member);

                        System.out.println("\n[데이터 삽입 성공]\n");
                        break;
                    }
                }
            } else if (mode == 2) {

                System.out.println("\n[조회할 데이터의 아이디를 입력 하십시오.]\n");

                MemberDAO DAO = new MemberDAO();
                MemberDTO member;

                while(true) {
                    System.out.print("\n아이디 입력 : ");
                    set = br.readLine();
                    if (!set.equals("")) {
                        member = DAO.select(set); break;
                    } else {
                        System.out.println("[잘못된 입력]");
                    }
                }

                System.out.println("\n[데이터 조회 성공]\n");
                System.out.println(member.toString() + "\n");

            } else if (mode == 3) {

                System.out.println("\n[수정할 데이터의 아이디를 입력 하십시오.]\n");

                while(true) {
                    System.out.print("아이디 입력 : ");
                    set = br.readLine();
                    if (set.equals("")) {
                        System.out.println("[잘못된 입력]"); continue;
                    }
                    break;
                }

                MemberDAO DAO = new MemberDAO();
                MemberDTO member = DAO.select(set);

                if (member != null) {
                    while(true) {
                        System.out.println("\n[정보를 순서대로 입력 하십시오.] + 아무것도 입력하지 않을 시, 변경하지 않습니다.\n");

                        System.out.print("\n이전 비밀번호 : " + member.getPwd() + "\n새로운 비밀번호 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setPwd(set);
                        }
                        System.out.print("\n이전 닉네임 : " + member.getNickname() + "\n새로운 닉네임 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setNickname(set);
                        }
                        System.out.print("\n이전 전화번호 : " + member.getPhone() + "\n새로운 전화번호 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setPhone(set);
                        }
                        System.out.print("\n이전 이메일 : " + member.getEmail() + "\n새로운 이메일 입력 : ");
                        set = br.readLine();
                        if (!set.equals("")) {
                            member.setEmail(set);
                        }

                        System.out.println(member.toString() + "\n1을 입력하면 수정을 진행하고, 아니라면 재입력을 진행 합니다.");
                        mode = Integer.parseInt(br.readLine());
                        if (mode == 1) { break; }
                    }

                    member = DAO.update(member);
                    if (member != null) {
                        System.out.println(member.toString() + "\n");
                        System.out.println("\n[데이터 수정 성공]\n");
                    } else {
                        System.out.println("\n[데이터 수정 실패]\n");
                    }

                } else {
                    System.out.println("\n[존재하지 않는 아이디입니다.]\n");
                }

            } else if (mode == 4) {
                System.out.println("\n[삭제할 데이터의 아이디를 입력 하십시오.]\n");
                MemberDAO DAO = new MemberDAO();

                while(true) {
                    System.out.print("아이디 입력 : ");
                    set = br.readLine();
                    if (set.equals("")) {
                        System.out.println("[잘못된 입력]"); continue;
                    }
                    break;
                }

                set = DAO.delete(set);
                MemberDTO DTO;

                if (set != null) {
                    DTO = DAO.select(set);
                    if (DTO == null) {
                        System.out.println("\n[데이터가 정상적으로 삭제 되었습니다.]\n");
                    } else {
                        System.out.println("\n[삭제 실패]\n");
                    }
                } else {
                    System.out.println("\n[삭제 실패]\n");
                }

            } else if (mode == 5) {
                System.out.println("\n[전체 데이터를 조회합니다.]\n");

                MemberDAO DAO = new MemberDAO();
                List<MemberDTO> list = DAO.findAll();

                for (MemberDTO DTO : list) {
                    System.out.println(DTO.toString() + "\n");
                }

            } else if (mode == 6) {
                System.out.println("\n[종료 되었습니다.]\n");
                break;
            } else {
                System.out.println("\n[잘못된 입력입니다. 다시 입력 하십시오.]\n");
            }
        }
    }
}