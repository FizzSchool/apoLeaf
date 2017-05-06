package com.example.fizzbuzz.leafapo;

import android.content.Context;
import android.widget.Toast;

import com.example.fizzbuzz.leafapo.com.content.ApoPage;
import com.example.fizzbuzz.leafapo.com.helper.LyricParser;

import java.util.ArrayList;

/**
 * Created by Fizz Buzz on 4/14/2017.
 */

public class ApoData {
    private ArrayList<ApoPage> apoPages;

    private Context context;

    public ApoData(Context context){
        this.context = context;


        LyricParser lyricParser = new LyricParser(this.context);
        //a.getLyricAndTime(R.raw.t);
        Toast.makeText(this.context, lyricParser.getLyricAndTime(R.raw.t).get(1).getPosition() +"", 3000).show();
        //
        ArrayList<String> apoContents;
        apoPages = new ArrayList<ApoPage>();

        // data
        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata2");
        apoContents.add("Yokkata3");
        apoContents.add("Yokkata");
        apoPages.add(new ApoPage(apoContents, "7!!", "I hate you", 0, "#000000", "#ffffff", "#ffffff", "#3C3C3C").setLyrics(lyricParser.getLyricAndTime(R.raw.t)));


        apoContents = new ArrayList<String>();
        apoContents.add("Hôm nay, đây là lần cuối commit của ứng dụng này. Tớ chẳng thể làm thêm nữa =\"= Bữa làm rớt điện thoại nên đi luôn roài.");
        apoContents.add("Chắc là tớ chẳng có duyên gì với cậu nữa, không thể với tới, tại sao mà bất cứ điều gì cũng ngăn cản tớ vậy.");
        apoContents.add("Tớ nhờ người gửi cậu ứng dụng này. Đừng block nhé. Thỉnh cầu nho nhỏ của tớ. ");
        apoContents.add("Nếu có thể là người cuối được loại bỏ bởi cậu, tớ sẽ chấp nhận... ");
        apoContents.add("Thanh bar ở trên là mục Tìm kiếm, note cuối của tớ và danh sách nhạc ý. Nếu ứng dụng có lỗi gì cậu thông cảm nhé! >\"<");
        apoPages.add(new ApoPage(apoContents, "Nandemonaiya", "I hate you", 1, "#ffffff", "#000000", "#000000", "#4A8CC3"));


        apoContents = new ArrayList<String>();
        apoContents.add("Ngày 3, tớ chẳng còn biết làm gì ngoài đau lòng, cả ngày chỉ phá hoại bản thân ._. ");
        apoContents.add("Ngồi đọc lại những gì cậu gửi tớ, cứ bồi hồi sao ý. ._. ");
        apoContents.add("Bài này là River flow in you mà mỗi lần nghe tớ lại nghĩ đến cậu nè ._. srr vì đã gán ghép nhé!! Chắc cậu không thích nữa đâu ");

        apoPages.add(new ApoPage(apoContents, "River flow in you", "I hate you", 2, "#ffffff", "#1D1D1D", "#1D1D1D", "#1D1D1D"));


        apoContents = new ArrayList<String>();
        apoContents.add("Hôm nay, tớ rất khó thở, rất rất rất đau.");
        apoContents.add("Liệu rằng tớ còn cơ hội hàn gắn không?");
        apoContents.add("Chúng ta đã xa được bao lâu rồi, 1 tháng hay là 1 năm?");
        apoContents.add("Lần đầu tiên, tớ biết cảm giác lo lắng cho người thân là như thế nào, biết cảm giác xa cách thực sự, mất mát thực sự thế nào, cảm giác nghẹn ngào khi ăn mà người thân đã từng vì tớ. Tớ nuốt không nổi. ");
        apoContents.add("Liệu cậu có trốn tớ không?");
        apoPages.add(new ApoPage(apoContents, "On rainy day", "I hate you", 3, "#000000", "#A8A8A8", "#A8A8A8", "#3C3C3C").setLyrics(lyricParser.getLyricAndTime(R.raw.on_rainy_day)));


        apoContents = new ArrayList<String>();
        apoContents.add("3 ngày sau khi tớ sa vào lưới tình của cậu, tớ đã từng véo má mình, hỏi rằng đây là mơ, và tớ không muốn đó là mơ??? Thật đó, tớ thực sự đã nghĩ đó là mơ và rồi ... 3 tuần trước, mỗi lần thức dậy tớ đã giật mình, thở dốc, dụi mắt và mong mọi chuyện xảy ra chỉ là mơ.");
        apoContents.add("It was only just a dream???");
        apoContents.add("");
        apoPages.add(new ApoPage(apoContents, "Just A Dream", "I hate you", 4, "#ffffff", "#1A1A1A", "#1A1A1A", "#232323").setLyrics(lyricParser.getLyricAndTime(R.raw.just_a_dream)));

        apoContents = new ArrayList<String>();
        apoContents.add("Năm 5 tuổi, lúc còn bé tí, tớ chỉ đứng 1 mình thật lâu đợi bằng được người thân trở về ");
        apoContents.add("Năm 21 tuổi, tớ chờ cậu thật lâu để cậu quay trở lại đây với tớ.");
        apoContents.add("Nhưng cậu đã không...");
        apoPages.add(new ApoPage(apoContents, "Shelter", "I hate you", 5, "#000000", "#f0a591", "#f0a591", "#FFDDAD"));

        apoContents = new ArrayList<String>();
        apoContents.add("Tỉ lệ để tớ gặp cậu là bao nhiêu. 1% hay bao nhiêu. Và giữa 1% ấy, bao nhiêu % tớ có thể níu kéo cậu. Mỗi lần nghĩ đến, tớ chẳng hiểu sao bản thân phải do dự. Tớ biết ngày đến HCM sẽ là nỗi đau, có lẽ sẽ là rất lớn trong cuộc đời tớ. Tớ biết chứ. Hãy cứ để bản thân khóc, để rồi trưởng thành hơn nữa, và không phải rơi lệ vì ai đó nữa");
        apoContents.add("Đây là bài hát cậu gửi mà tớ rất thích");
        apoContents.add("Như tớ đã từng...");
        apoPages.add(new ApoPage(apoContents, "If", "I hate you", 6, "#ffffff", "#1A1A1A", "#1A1A1A", "#242424").setLyrics(lyricParser.getLyricAndTime(R.raw.if_kana)));

        apoContents = new ArrayList<String>();
        apoContents.add("Cậu còn nghe tớ nói không???");
        apoContents.add("Mỗi ngày tớ đều hỏi vậy? Theo dõi cậu chi? ");
        apoContents.add("Theo dõi từng bài đăng trên Thiên Lam, tớ thật sự chẳng thể phân biệt được nữa.");
        apoContents.add("Cậu kiên định lắm, tớ không đủ sức giữ lấy cậu được nữa. Mọi chuyện rồi cũng sẽ kết thúc như khoảng thời gian đã dự kiến -1 năm");
        apoContents.add("Mặc dù tớ vẫn muốn nắm tay cậu thật chặt");
        apoPages.add(new ApoPage(apoContents, "Đạo mộ bút ký - Linh Khế", "I hate you", 7, "#000000", "#fefefe", "#fefefe", "#020202"));

        apoContents = new ArrayList<String>();
        apoContents.add("Bài này cậu nhớ cắm tai nghe vào đó nhé, hiệu ứng nó vui vui.");
        apoContents.add("...    ");
        apoContents.add("Vậy là tớ không được spam cậu nữa rồi, sẽ cố không lo lắng và nghĩ về cậu nữa");
        apoContents.add("Chuyến đi này ");
        apoContents.add("Là để gặp gỡ, trước khi chúng ta sẽ không bao giờ nhận ra nhau nữa.");
        apoContents.add("Tớ không cần gì nữa, chỉ cần gặp mặt cậu thôi, gặp mặt cũng được. Rồi rồi, tớ sẽ rút, để cậu, như ý cậu muốn");
        apoPages.add(new ApoPage(apoContents, "Ngẫu hứng", "I hate you", 8, "#ffffff", "#000c18", "#000c18", "#000C18"));

        apoContents = new ArrayList<String>();
        apoContents.add("Hãy thơm môi em khi còn thắm đỏ");
        apoContents.add("Tớ thậm chí còn chưa được chạm vào cậu cơ. Cơ mà điều ấy chẳng còn chút quan trọng gì nữa cả, khi mà tớ đã tan biến khỏi cuộc đời cậu.");
        apoContents.add("Tớ ích kỉ và cố giữ khư khư cậu ở bên mình, đâu cũng vậy, cả game nữa, và bám riết cậu.");
        apoContents.add("Hãy coi như tớ đã chết, tớ đã tan biến như tớ đã từng nói. Cậu sẽ luôn luôn ổn thôi mà.");
        apoPages.add(new ApoPage(apoContents, "While your lips are still red", "I hate you", 9, "#ffffff", "#151515", "#151515", "#151515").setLyrics(lyricParser.getLyricAndTime(R.raw.while_lips)));

        apoContents = new ArrayList<String>();
        apoContents.add("Bài này ý, tớ không biết đã nghe đi nghe lại biết bao nhiêu lần.");
        apoContents.add("Chẳng biết nữa, tớ đã nghĩ rằng bài hát này nó gắn liền với cậu, với kí ức của cậu. ");
        apoContents.add("Và tớ đã mặc cho bài nhạc này chạy qua chạy lại trong não");
        apoContents.add("Và bây giờ");
        apoContents.add("Đúng");
        apoContents.add("...");
        apoContents.add("Tớ cũng rất vui vẻ");
        apoPages.add(new ApoPage(apoContents, "Tôi rất vui vẻ", "I hate you", 10 , "#000000", "#ffffff", "#ffffff", "#FFFFFF").setLyrics(lyricParser.getLyricAndTime(R.raw.toi_rat_vv)));

        apoContents = new ArrayList<String>();
        apoContents.add("Tớ, thực sự lạc lõng và biệt lập, tớ cũng đánh mất rất nhiều mối quan hệ tốt, bạn bè,... và cả cậu nữa, ... Nó giống như...");
        apoContents.add("\"Mọi thứ mà người chạm vào, đều sẽ chết\"");
        apoContents.add("Nó giống như là");
        apoContents.add("\"Mọi thứ mà ngươi viết tên, ngươi sẽ không bao giờ có\"");
        apoContents.add("Nó mơ hồ như những suy nghĩ mà tớ thể hiện trên giấy vậy.Cậu hiểu điều đó chứ??? Cậu hiểu được cảm giác khi tớ viết những dòng này chứ???? ");
        apoContents.add("CẬU HIỂU ĐƯỢC CẢM GIÁC TỚ PHẢI TỪNG GÀO THÉT TRONG BẤT LỰC BAO NHIÊU LẦN KHÔNG??? ");
        apoPages.add(new ApoPage(apoContents, "Falling", "I hate you", 11, "#ffffff", "#c27279", "#c27279", "#864951").setLyrics(lyricParser.getLyricAndTime(R.raw.falling)));

        apoContents = new ArrayList<String>();
        apoContents.add("Tớ đoán là");
        apoContents.add("Bài hát này, cậu cũng đã không còn tin vào tớ nữa.");
        apoContents.add("Chúng mình đã cãi nhau vào hôm đó. Và lúc đó tớ không im lặng, và rồi chúng ta im lặng dài từ đó một vài ngày");
        apoContents.add("Và rồi, cậu lại nghe bài tình ca sầu này đúng không? Baka");
        apoPages.add(new ApoPage(apoContents, "Diễn viên", "I hate you", 12, "#000000", "#d3cddc", "#d3cddc", "#433C3B").setLyrics(lyricParser.getLyricAndTime(R.raw.dien_vien)));

        apoContents = new ArrayList<String>();
        apoContents.add("TỚ GHÉT CẬU LẮM, cảm xúc lẫn lộn nữa, nếu như cái thứ cảm giác hỗn độn này có thể hóa thành chông thì tớ mong nó chọt được cậu - kẻ đáng ghét kia >\"<");
        apoContents.add("Tớ đối diện mỗi sáng là nỗi sợ hãi, biết là nó sắp đến, và tớ biết sẽ lạc lõng nơi đó.");
        apoContents.add("Tớ biết tớ sẽ bơ vơ. Liệu cậu có kéo tớ lại không nhỉ?");
        apoContents.add("*lắc đầu* Cậu sẽ không như vậy đâu >\"< Ngưng ảo tưởng đi mậy");
        apoContents.add("Tớ đã như vậy đấy. Chìm trong muôn vàn tình huống. Hoang tưởng rồi chợt cay hết đôi mắt này.");
        apoPages.add(new ApoPage(apoContents, "Bring me back to life", "I hate you", 13, "#ffffff", "#000000", "#000000", "#000000").setLyrics(lyricParser.getLyricAndTime(R.raw.bring_me_back)));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Let me hear", "I hate you", 14, "#000000", "#ffd6e7", "#ffd6e7", "#AB97C5"));

        apoContents = new ArrayList<String>();
        apoContents.add("Tớ vẫn còn rất nhiều dự định, rất nhiều thứ cute muốn làm với cậu. ");
        apoContents.add("Những thứ vô cùng nhỏ nhoi, những công việc thường ngày, những việc cậu làm, tớ đều muốn về nhà sau một ngày mệt mỏi để làm cùng cậu.");
        apoContents.add("Nhưng có lẽ phải bỏ dỡ rồi, ... ");
        apoPages.add(new ApoPage(apoContents, "Next to you", "I hate you", 15, "#ffffff", "#020202", "#020202", "#000000"));

        apoContents = new ArrayList<String>();
        apoContents.add("Hôm nay là ngày ... , tớ đãng trí quên mang chìa khóa theo. Cũng may mượn tạm đc phòng bên cạnh. Chẳng có ai cả. Và Tớ đang bất cần, nằm nhìn trần nhà, và k. Quá khứ nó cứ ùa về, tớ, tớ không ngăn lại được. Hôm nay, tớ bỏ bữa, đói, tớ chẳng cần gì cả. Một chút suy nghĩ tiêu cực chợt đến. Tớ cứ tưởng ngày trước, khi cậu mắng tớ khi tớ nhắc đến từ tan biến. Thì giờ đây, nếu có thể tan biến, thì đó là điều tốt nhất phải không?");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Vừa đủ", "I hate you", 16, "#ffffff", "#1f1f1f", "#1f1f1f", "#212121").setLyrics(lyricParser.getLyricAndTime(R.raw.vua_du)));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "All about us", "I hate you", 17, "#ffffff", "#040404", "#040404", "#090808").setLyrics(lyricParser.getLyricAndTime(R.raw.all_about_us)));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Hello, how are you?", "I hate you", 18, "#333333", "#ececec", "#ececec", "#D9D9D9").setLyrics(lyricParser.getLyricAndTime(R.raw.hello_how_a_u)));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "1 year 2 months and 20 days", "I hate you", 19, "#ffffff", "#545d69", "#545d69", "#FEF7DD").setLyrics(lyricParser.getLyricAndTime(R.raw.oneett)));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Safe and sound", "I hate you", 20, "#ffffff", "#1b1b1b", "#1b1b1b", "#1A1A1A"));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Hotaru", "I hate you", 21, "#ffffff", "#1b1b1b", "#1b1b1b", "#1C1C1C").setLyrics(lyricParser.getLyricAndTime(R.raw.hotaru)));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Ori and the blind forest - Light of Nibel", "I hate you", 22, "#ffffff", "#000000", "#000000", "#000000"));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Teshima Aoi - Ai wo Komete Umi", "I hate you", 23, "#555555", "#cfcb8a", "#cfcb8a", "#839340"));

        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Dango daikazoku", "I hate you", 24, "#170002", "#f1c4cf", "#f1c4cf", "#F1C4CF"));

        apoContents = new ArrayList<String>();
        apoContents.add("Bài hát cuối cùng");
        apoContents.add("Ngày thứ 26");
        apoContents.add("Tớ muốn níu cậu lại, một lần và mãi mãi");
        apoContents.add("Với tất cả chút sức lực còn lại và sự chân tình");
        apoContents.add("Tớ có 3 ngày, chỉ ráng gặp cậu");
        apoContents.add("Nỗ lực để không phải hối hận hay lại hối hận đây??? ");
        apoContents.add("Nếu ");
        apoContents.add("Nếu có thể có lại cậu, tớ sẽ ôm cậu thật chặt và khóc... ");
        apoContents.add("Nếu ");
        apoContents.add("Nỗ không giữ được cậu nữa, tớ sẽ ôm tớ thật chặt và khóc...");
        apoPages.add(new ApoPage(apoContents, "Let it her go", "I hate you", 25, "#555555", "#dedede", "#dedede", "#E7E7E7").setLyrics(lyricParser.getLyricAndTime(R.raw.let_it_her_go)));


    }

    public ArrayList<ApoPage> getApoPages() {
        return apoPages;
    }

    public void setApoPages(ArrayList<ApoPage> apoPages) {
        this.apoPages = apoPages;
    }
}
