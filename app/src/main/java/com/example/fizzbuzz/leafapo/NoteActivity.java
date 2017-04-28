package com.example.fizzbuzz.leafapo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fizzbuzz.leafapo.com.base.BaseActivity;

public class NoteActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        init();

        TextView tv = (TextView) findViewById(R.id.note);
        tv.setText("Những dòng note cuối cùng\n" +
                "\n" +
                "Vậy là hơn 1 tháng trôi qua, từ lúc mất cậu chính thức – cũng là hơn 4 tháng, từ lúc gây nhau, và cũng từ lúc ấy mọi chuyện đã chuyển sang một hướng khác, cũng là lúc mà cậu không còn tin tớ nữa. Khoảng thời gian mà tớ vẫn ngu ngơ và thương cậu như hồi mới ban đầu, như một người thân mà tớ luôn dặn lòng không bao giờ được để mất. \n\n" +
                "Tớ viết những dòng note này, không phải để thanh minh, không phải để vãn hồi thứ gì đó. Tớ viết app này, không phải để làm cậu cảm thấy khó xử. Nếu cậu đọc được đến những dòng này, tớ đã rất mừng rồi. Hãy coi ứng dụng này, là những gì đẹp đẽ còn tồn tại, và cũng là những điều đau buồn đã từng xảy ra, là những suy nghĩ ngẫu nhiên trong tớ mà cậu sẽ chẳng còn phải bận tâm để tìm hiểu nữa. Tớ hi vọng nó có thể đẹp được như dư ảnh của pháo hoa lúc tàn vậy. Nếu nó có lỗi, hãy nghĩ đó là một bản beta mà thôi, tớ cũng đã trau chuốt nó trước lần commit cuối cùng lắm rồi.\n\n" +
                "Những ngày dài trôi qua, chưa bao giờ tớ cảm thấy muốn thời gian trôi nhanh đến thế. Tớ đã rất đau đớn và cả ngu ngốc nữa, cũng từng có cả những suy nghĩ dại dột. Khó thở, nghẹn lời, cay mắt, thở dốc, và mất ngủ nhưng những thứ đó chỉ là cảm giác riêng  của tớ thôi. Tớ đã dốc nước mắt vào rất nhiều lần, chẳng hiểu sao nó cứ đổ mà không kiềm được. Ngồi viết app và bỗng dưng mủi lòng, òa lên khi chẳng có ai ở đây cả và muốn dẹp bỏ cái thứ mà mình đang dồn công sức. \n\n" +
                "Đến lúc này, tớ biết tại sao tớ lại mãi chẳng quên được cậu, lại không muốn buông cậu. Có lẽ là do mong muốn chiếm hữu và muốn ở bên cạnh cậu quá lớn, vốn đã từng được coi là mục đích mà bản thân vẫn chưa từ bỏ. Và rồi, sự cương quyết và bướng bỉnh đến chắc chắn của cậu đã làm tớ phải thay đổi, tớ sẽ là tớ của ngày trước, sẽ chẳng cầu mong sự yêu thương của người khác, sẽ chúc cho cậu gặp nhiều may mắn.\n" +
                "Có lẽ, tớ bị hấp dẫn bởi những điều khác biệt, khác biệt với những điều quy tắc của bản thân tớ. Tớ bị hấp dẫn bởi cậu, một cô gái người Hoa và làm tớ nghe nhạc Hoa nhiều hơn, là cô gái miền Tây với cái giọng đầy dễ thương và ma mị, là người nóng nảy và sẵn sàng dẹp bỏ mọi suy nghĩ sai lệch của tớ. Nhưng rồi, những khác biệt ấy lại tạo một khoảng cách quá xa của chúng ta, cả mặt thực và ảo, tâm hồn và vật lí. Tớ biết tớ đã dốc cạn tấm chân tình này vào những điều khác biệt, vào một cô gái đã đi làm, không còn mơ màng, và thực dụng hơn nhiều lắm.\n\n" +
                "Chuyến đi này, chuyện của chúng ta, sẽ chẳng còn gì cả. Nếu là lần gặp mặt cuối cùng, thì cũng chẳng có chuyện gì đâu, khi mà tất cả dừng ở chữ “thương”. Tất cả đã dừng, tớ không nghĩ rằng chuyến đi này có nghĩa, không nghĩ có thể dễ dàng gặp được cậu. Tất cả đã dừng, tất cả sẽ không đủ để bù cho một cái ôm, cầm tay hay chạm tay gì cả, vì, “Tất cả đã dừng”. Tớ đã chẳng còn là gì trong mắt của cậu nữa, không còn là thứ gì đẹp đẽ có thể che chở cho cậu được nữa, một lần nữa. Thậm chí, tớ không còn quyền để “chạm” và “với” tới cậu.\n\n" +
                "Cậu ơi, nếu như, cậu mở lòng với một ai đó một lần nữa, tớ dặn nè.  Hãy trân trọng họ, kể cả trong những lúc cãi vã hay nóng nảy, vì chẳng có ai hoàn hảo trong những lúc đó đâu, để rồi phải đánh mất họ một lần nữa. Tớ không phải kẻ hoàn hảo, những điều tớ dặn cậu, hi vọng sẽ có ích cho cậu, một chút.\n\n" +
                ".\n" +
                ".\n" +
                ".\n\n" +
                "Tớ luôn thương cậu\n\n" +
                ".\n" +
                ".\n" +
                ".\n" +
                "Đôi tay gầy này, bản thể này, nếu không thể được yêu thương được nữa, thì đã đến lúc, có lẽ, nó không thể níu thêm được nữa rồi!\n" +
                "\n");
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setTypeface(this.typeface);
    }
}
