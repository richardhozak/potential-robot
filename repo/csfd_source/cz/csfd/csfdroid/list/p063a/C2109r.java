package cz.csfd.csfdroid.list.p063a;

import cz.csfd.csfdroid.R;
import cz.csfd.csfdroid.data.entity.Comment;
import cz.csfd.csfdroid.list.itemview.CommentItemView;

/* compiled from: MyCommentListItem */
public class C2109r extends C2098f {
    public C2109r(Comment comment) {
        super(comment);
        this.c = R.layout.my_comment_item;
        this.a = true;
    }

    public Class<?> mo3427b() {
        return CommentItemView.class;
    }
}
