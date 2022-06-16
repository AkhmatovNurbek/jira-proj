package jira.domains.auth;

import jira.domains.BaseEntity;
import jira.enums.CommentType;
import jira.enums.TaskStatus;
import lombok.*;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Organization implements BaseEntity {
    private Long id;
    private String name;
    private Long ownerId;
    private List<Project> projects;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    static class Project {
        private Long id;
        private String name;
        private List<Column> columns;
        private List<Member> member;
        private LocalDateTime deadline;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        @ToString
        static class Column {
            private Long id;
            private String name;
            private List<Task> tasks;

            @Getter
            @Setter
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            @ToString
            static class Task {
                private Long id;
                private String name;
                private List<Comment> comments;
                private List<Member> members;
                private TaskStatus status = TaskStatus.PROGRESS;

                @Getter
                @Setter
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                @ToString
                static class Comment {
                    private Long id;
                    private String description;
                    private CommentType type;
                }

                @Getter
                @Setter
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                @ToString
                static class Member {
                    private Long id;
                    private Long username;
                    private Long userId;
                    private Boolean isTeamLead;
                }
            }
        }
    }

}
