/**
 * 고려할 것
 *  - 무조건 조회만 가능. 수정 삭제 아무것도 안됨
 *   - 마커 수정 X
 *   - 위치 수정 X
 *   - 즐겨찾기 이런 것도 없음.
 *
 *   - 나중에 구글 스프레드 시트와 연동하면 그 때 고민해보기.
 *
 *
 *   - marker.js 는 on off 메서드만 제공
 *   - 생성자 만들 때 setMap 까지 하는 걸로
 *
 *   - 인포윈도우는?
 */

export default class Marker {

    #marker;

    #name;
    #time;

    constructor(pictureObj) {
        this.#name = pictureObj.name;
        this.#time = pictureObj.time

        const position = new kakao.maps.LatLng(pictureObj.latitude, pictureObj.longitude)

        const imageSrc = pictureObj.imageLink;
        const imageSize = new kakao.maps.Size(32, 32);
        const imageOption = {offset: new kakao.maps.Point(16, 32)};
        const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);

        this.#marker = new kakao.maps.Marker({
            position : position,
            image: markerImage
        })
        //console.log(`Marker Object`);
        //console.log(this.#marker);
    }

    get marker() {
        return this.#marker;
    }
}