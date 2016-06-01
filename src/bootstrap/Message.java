package bootstrap;

/**
 * 
 * @author zhuss
 * @param <T>
 */
public class Message<T> {
	
	/**
	 * 消息的唯一标识
	 */
	private String id;
	
	/**
	 * 用于验证消息体完整性
	 * 使用MD5算法生成的标识，用来验证body在网络传输过程中是否受损
	 */
	private String md5;
	
	/**
	 * 消息类型(以此来处理消息)
	 */
	private String type;
	
	/**
	 * 消息主体
	 */
	private T body;
	

}
