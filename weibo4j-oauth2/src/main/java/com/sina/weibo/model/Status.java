package com.sina.weibo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sina.weibo.http.Response;
import com.sina.weibo.json.JSONArray;
import com.sina.weibo.json.JSONException;
import com.sina.weibo.json.JSONObject;

public class Status extends WeiboResponse implements java.io.Serializable {

	private static final long serialVersionUID = -8795691786466526420L;

	public static List<Status> constructStatus(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONObject().getJSONArray("statuses");
			List<Status> statuses = new ArrayList<Status>(list.length());
			for (int i = 0; i < list.length(); i++) {
				statuses.add(new Status(list.getJSONObject(i)));
			}
			return statuses;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}
	}

	public static StatusWapper constructWapperStatus(Response res) throws WeiboException {
		JSONObject jsonStatus = res.asJSONObject(); //asJSONArray();
		JSONArray statuses = null;
		try {
			if (!jsonStatus.isNull("statuses")) {
				statuses = jsonStatus.getJSONArray("statuses");
			}
			if (!jsonStatus.isNull("reposts")) {
				statuses = jsonStatus.getJSONArray("reposts");
			}
			int size = statuses.length();
			List<Status> status = new ArrayList<Status>(size);
			for (int i = 0; i < size; i++) {
				status.add(new Status(statuses.getJSONObject(i)));
			}
			long previousCursor = jsonStatus.getLong("previous_curosr");
			long nextCursor = jsonStatus.getLong("next_cursor");
			long totalNumber = jsonStatus.getLong("total_number");
			String hasvisible = jsonStatus.getString("hasvisible");
			return new StatusWapper(status, previousCursor, nextCursor, totalNumber, hasvisible);
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	private User user = null; //作者信息
	private Date createdAt; //status创建时间
	private String id; //status id
	private String mid; //微博MID
	private long idstr; //保留字段，请勿使用
	private String text; //微博内容
	private Source source; //微博来源
	private boolean favorited; //是否已收藏
	private boolean truncated;
	private long inReplyToStatusId; //回复ID
	private long inReplyToUserId; //回复人ID
	private String inReplyToScreenName; //回复人昵称
	private String thumbnailPic; //微博内容中的图片的缩略地址
	private String bmiddlePic; //中型图片
	private String originalPic; //原始图片
	private Status retweetedStatus = null; //转发的博文，内容为status，如果不是转发，则没有此字段
	private String geo; //地理信息，保存经纬度，没有时不返回此字段
	private double latitude = -1; //纬度
	private double longitude = -1; //经度
	private int repostsCount; //转发数
	private int commentsCount; //评论数
	private int attitudesCount; //赞数
	private String annotations; //元数据，没有时不返回此字段

	private int mlevel;

	private Visible visible;

	public Status() {

	}

	public Status(JSONObject json) throws WeiboException, JSONException {
		constructJson(json);
	}

	public Status(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		constructJson(json);
	}

	public Status(String str) throws WeiboException, JSONException {
		// StatusStream uses this constructor
		super();
		JSONObject json = new JSONObject(str);
		constructJson(json);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAnnotations() {
		return annotations;
	}

	public String getBmiddlePic() {
		return bmiddlePic;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getGeo() {
		return geo;
	}

	public String getId() {
		return id;
	}

	public long getIdstr() {
		return idstr;
	}

	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public long getInReplyToStatusId() {
		return inReplyToStatusId;
	}

	public long getInReplyToUserId() {
		return inReplyToUserId;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getMid() {
		return mid;
	}

	public int getMlevel() {
		return mlevel;
	}

	public String getOriginalPic() {
		return originalPic;
	}

	public int getRepostsCount() {
		return repostsCount;
	}

	public Status getRetweetedStatus() {
		return retweetedStatus;
	}

	public Source getSource() {
		return source;
	}

	public String getText() {
		return text;
	}

	public String getThumbnailPic() {
		return thumbnailPic;
	}

	public User getUser() {
		return user;
	}

	public Visible getVisible() {
		return visible;
	}

	public int getAttitudesCount() {
		return attitudesCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean isFavorited() {
		return favorited;
	}

	public boolean isTruncated() {
		return truncated;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public void setBmiddlePic(String bmiddlePic) {
		this.bmiddlePic = bmiddlePic;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIdstr(long idstr) {
		this.idstr = idstr;
	}

	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}

	public void setInReplyToStatusId(long inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}

	public void setInReplyToUserId(long inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMlevel(int mlevel) {
		this.mlevel = mlevel;
	}

	public void setOriginalPic(String originalPic) {
		this.originalPic = originalPic;
	}

	public void setRepostsCount(int repostsCount) {
		this.repostsCount = repostsCount;
	}

	public void setRetweetedStatus(Status retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setThumbnailPic(String thumbnailPic) {
		this.thumbnailPic = thumbnailPic;
	}

	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setVisible(Visible visible) {
		this.visible = visible;
	}

	public void setAttitudesCount(int attitudesCount) {
		this.attitudesCount = attitudesCount;
	}

	@Override
	public String toString() {
		return "Status [user=" + user + ", idstr=" + idstr + ", createdAt=" + createdAt + ", id=" + id + ", text="
				+ text + ", source=" + source + ", favorited=" + favorited + ", truncated=" + truncated
				+ ", inReplyToStatusId=" + inReplyToStatusId + ", inReplyToUserId=" + inReplyToUserId
				+ ", inReplyToScreenName=" + inReplyToScreenName + ", thumbnailPic=" + thumbnailPic + ", bmiddlePic="
				+ bmiddlePic + ", originalPic=" + originalPic + ", retweetedStatus=" + retweetedStatus + ", geo=" + geo
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", repostsCount=" + repostsCount
				+ ", commentsCount=" + commentsCount + ", attitudesCount= " + attitudesCount + ", mid=" + mid
				+ ", annotations=" + annotations + ", mlevel=" + mlevel + ", visible=" + visible + "]";
	}

	private void constructJson(JSONObject json) throws WeiboException {
		try {
			createdAt = parseDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
			id = json.getString("id");
			mid = json.getString("mid");
			idstr = json.getLong("idstr");
			text = json.getString("text");
			if (!json.getString("source").isEmpty()) {
				source = new Source(json.getString("source"));
			}
			inReplyToStatusId = getLong("in_reply_to_status_id", json);
			inReplyToUserId = getLong("in_reply_to_user_id", json);
			inReplyToScreenName = json.getString("in_reply_toS_screenName");
			favorited = getBoolean("favorited", json);
			truncated = getBoolean("truncated", json);
			thumbnailPic = json.getString("thumbnail_pic");
			bmiddlePic = json.getString("bmiddle_pic");
			originalPic = json.getString("original_pic");
			repostsCount = json.getInt("reposts_count");
			commentsCount = json.getInt("comments_count");
			attitudesCount = json.getInt("attitudes_count");
			annotations = json.getString("annotations");
			if (!json.isNull("user"))
				user = new User(json.getJSONObject("user"));
			if (!json.isNull("retweeted_status")) {
				retweetedStatus = new Status(json.getJSONObject("retweeted_status"));
			}
			mlevel = json.getInt("mlevel");
			geo = json.getString("geo");
			if (geo != null && !"".equals(geo) && !"null".equals(geo)) {
				getGeoInfo(geo);
			}
			if (!json.isNull("visible")) {
				visible = new Visible(json.getJSONObject("visible"));
			}
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(), je);
		}
	}

	private void getGeoInfo(String geo) {
		StringBuffer value = new StringBuffer();
		for (char c : geo.toCharArray()) {
			if (c > 45 && c < 58) {
				value.append(c);
			}
			if (c == 44) {
				if (value.length() > 0) {
					latitude = Double.parseDouble(value.toString());
					value.delete(0, value.length());
				}
			}
		}
		longitude = Double.parseDouble(value.toString());
	}

}
