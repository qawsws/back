package me.shinsunyoung.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    // 스프링 시큐리트가 비밀번호, 권한, 상태를 확인하여 로그인 처리를 실행함
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException(email));
    }
}
