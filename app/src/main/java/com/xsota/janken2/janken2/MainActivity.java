package com.xsota.janken2.janken2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

  // 敵の手
  @Bind(R.id.teki)
  ImageView teki;

  // 結果の文字
  @Bind(R.id.janken_text)
  TextView text;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
  }

  @OnClick({R.id.gu, R.id.tyo, R.id.pa})
  public void janken(ImageView hand){
    int myHand = 0;
    int tekiHand = 0;
    int syouhai = 0;

    // 自分の出した手はなんですか
    switch (hand.getId()){
      case R.id.gu:
        Toast.makeText(this,"あなたはぐぅを出した",Toast.LENGTH_SHORT).show();
        myHand = 0;
        break;

      case R.id.tyo:
        Toast.makeText(this,"あなたはちょきを出した",Toast.LENGTH_SHORT).show();
        myHand = 1;
        break;

      case R.id.pa:
        Toast.makeText(this,"あなたはぱぁを出した",Toast.LENGTH_SHORT).show();
        myHand = 2;
        break;
    }

    // 相手の出した手はなんですか
    Random random = new Random();
    tekiHand = random.nextInt(3);
    switch (tekiHand){
      case 0:
        teki.setImageResource(R.drawable.gu);
        break;
      case 1:
        teki.setImageResource(R.drawable.tyo);
        break;
      case 2:
        teki.setImageResource(R.drawable.pa);
        break;
    }

    // 勝敗はどうなってるんですか
    syouhai = ((myHand - tekiHand) + 3) % 3;
    switch (syouhai){
      case 0:
        text.setText("あいこ");
        break;
      case 1:
        text.setText("まけた");
        break;
      case 2:
        text.setText("かった");
        break;
    }

  }

}
