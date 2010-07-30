var stmnLEFT = 155; // 스크롤메뉴의 좌측 위치
var stmnGAP1 = 100; // 페이지 헤더부분의 여백 (이보다 위로는 올라가지 않음)
var stmnGAP2 = 100; // 스크롤시 브라우저 상단과 약간 띄움. 필요없으면 0으로 세팅
var stmnBASE = 300; // 스크롤메뉴 초기 시작위치 (아무렇게나 해도 상관은 없지만 stmnGAP1과 약간 차이를 주는게 보기 좋음)
var stmnActivateSpeed = 1; // 움직임을 감지하는 속도 (숫자가 클수록 늦게 알아차림)
var stmnScrollSpeed = 10; // 스크롤되는 속도 (클수록 늦게 움직임)


function RefreshStaticMenu()
{
  var stmnStartPoint, stmnEndPoint, stmnRefreshTimer;

  stmnStartPoint = parseInt(STATICMENU.style.top, 10);
  stmnEndPoint = document.body.scrollTop + document.body.clientHeight-570; // 높이가 높은메뉴이면 -되는 값을 증가시키세요
  if (stmnEndPoint < stmnGAP1) stmnEndPoint = stmnGAP1;

  if ( stmnStartPoint != stmnEndPoint ) {
    stmnScrollAmount = Math.ceil( Math.abs( stmnEndPoint - stmnStartPoint ) / 15 );
    STATICMENU.style.top = parseInt(STATICMENU.style.top, 10) + ( ( stmnEndPoint<stmnStartPoint ) ? -stmnScrollAmount : stmnScrollAmount );
    stmnRefreshTimer = stmnScrollSpeed;
  }
         else {
    stmnRefreshTimer = stmnActivateSpeed;
  }

  setTimeout ("RefreshStaticMenu();", stmnRefreshTimer);
}

 

function InitializeStaticMenu()
{
  STATICMENU.style.top =document.body.scrollTop - stmnBASE; 
  RefreshStaticMenu();
  STATICMENU.style.left = stmnLEFT;
}

