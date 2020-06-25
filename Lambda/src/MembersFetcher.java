
public interface MembersFetcher<T extends Member> {
    Member[] toMembers(Class<?> clazz);
}
