package com.example.coin.application;

import com.example.coin.domain.*;
import com.example.coin.presentation.MemberRequestDto;
import com.example.coin.presentation.MemberResponseDto;
import com.example.coin.presentation.RoomResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinService {

    private MemberRepository memberRepository;
    private RoomRepository roomRepository;


    @Autowired
    CoinService(MemberRepository memberRepository, RoomRepository roomRepository) {
        this.memberRepository = memberRepository;
        this.roomRepository = roomRepository;
    }

    public MemberResponseDto generateMember(MemberRequestDto memberRequestDto) {
        String name = memberRequestDto.getName();
        String phoneNumber = memberRequestDto.getPhoneNumber();

        if (memberRepository.findMemberByPhoneNumber(phoneNumber) != null) {
            throw new DuplicatePhoneException();
        }

        Member member = new Member(name, phoneNumber);
        memberRepository.saveMember(member);
        MemberResponseDto memberResponseDto = new MemberResponseDto(member);

        return memberResponseDto;
    }

    public MemberResponseDto getMemberInformation(String phoneNumber) {
        Member member = memberRepository.findMemberByPhoneNumber(phoneNumber);

        if (member == null) {
            throw new NotFoundMemberException();
        }

        MemberResponseDto memberResponseDto = new MemberResponseDto(member);
        return memberResponseDto;
    }

    public MemberResponseDto addSongCount(String phoneNumber, int count) {
        Member member = memberRepository.findMemberByPhoneNumber(phoneNumber);

        if (member == null) {
            throw new NotFoundMemberException();
        }

        member.setSongCount(member.getSongCount() + count);
        return new MemberResponseDto(member);
    }

    public Member decreaseSongCount(String phoneNumber, int count) {
        Member member = memberRepository.findMemberByPhoneNumber(phoneNumber);

        if (member == null) {
            throw new NotFoundMemberException();
        }

        if (member.getSongCount() < count) {
            throw new LackOfSongCountException();
        }
        member.setSongCount(member.getSongCount() - count);
        return member;
    }

    public Room useRoom(int roomNumber) {
        Room room = roomRepository.findRoomByNumber(roomNumber);

        // 존재하는지
        if (room == null) {
            throw new NotFoundRoomException();
        }

        // 사용가능한지
        if (room.getStatus() != RoomStatus.FINISHED) {
            throw new RoomUnavailableException();
        }

        room.setStatus(RoomStatus.USING);

        return room;
    }


    public Room changeRoomStatus(int roomNumber, String roomStatus) {
        Room room = roomRepository.findRoomByNumber(roomNumber);
        String upperRoomStatus = roomStatus.toUpperCase();

        // 존재하는지
        if (room == null) {
            throw new NotFoundRoomException();
        }

        // 올바른 상태명인지
        if (!upperRoomStatus.equals(RoomStatus.USING.name())
                && !upperRoomStatus.equals(RoomStatus.FINISHED.name())
                && !upperRoomStatus.equals(RoomStatus.INSPECTION.name())) {
            throw new InvalidRoomStatusException();
        }

        room.setStatus(RoomStatus.valueOf(upperRoomStatus));

        return room;
    }

    public List<RoomResponseDto> getAllRoom() {
        List<RoomResponseDto> roomResponseDtos = new ArrayList<>();

        for (Room room : roomRepository.findAllRooms()) {
            roomResponseDtos.add(new RoomResponseDto(room));
        }

        return roomResponseDtos;
    }

    public List<MemberResponseDto> getAllMember() {
        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();

        for (Member member : memberRepository.findAllMembers()) {
            memberResponseDtos.add(new MemberResponseDto(member));
        }

        return memberResponseDtos;
    }
}
