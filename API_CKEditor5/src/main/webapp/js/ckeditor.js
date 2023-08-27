const maxCharacters = 300;
const container = document.querySelector( '.demo-update' );
const progressCircle = document.querySelector( '.demo-update__chart__circle' );
const charactersBox = document.querySelector( '.demo-update__chart__characters' );
const wordsBox = document.querySelector( '.demo-update__words' );
const circleCircumference = Math.floor( 2 * Math.PI * progressCircle.getAttribute( 'r' ) );
const sendButton = document.querySelector( '.demo-update__send' );

// Editor 생성 : $('#editor')를 숨기고 그 뒤에 editor 생성
ClassicEditor
	.create( document.querySelector( '#editor' ), {
		toolbar: {
			items: [
				'FindAndReplace',
				'undo',
				'redo',
				'|',
				'outdent',
				'indent',
				'heading',
				'|',
				'bold',
				'italic',
				'strikethrough',
				'underline',
				'fontBackgroundColor',
				'fontColor',
				'|',
				'alignment',
				'bulletedList',
				'numberedList',
				'|',
				'link',
				'imageInsert',
				'insertTable',
				'blockQuote',
				'code',
				'codeBlock'
			]
		},
		language: 'ko',
		image: {
			toolbar: [
				'imageTextAlternative',
				'toggleImageCaption',
				'imageStyle:inline',
				'imageStyle:block',
				'imageStyle:side',
				'linkImage'
			]
		},
		table: {
			contentToolbar: [
				'tableColumn',
				'tableRow',
				'mergeTableCells',
				'tableCellProperties',
				'tableProperties'
			]
		},
		/* 글쓰기 영역 focus시 생기는 ckeditor 로고 커스텀 */
		ui: {
	        poweredBy: {
	            label: ''
	        }
	    },
	    /* 이미지 업로드 */
        simpleUpload: {
            uploadUrl: './uploadImage.do',
            withCredentials: true,
        },
        /* 자동 저장 */
        autosave: {
            save( editor ) {
              console.log(editor.getData());
                return saveData( editor.getData() );
            }
        },
        wordCount: {
            onUpdate: stats => {
                const charactersProgress = stats.characters / maxCharacters * circleCircumference;
                const isLimitExceeded = stats.characters > maxCharacters;
                const isCloseToLimit = !isLimitExceeded && stats.characters > maxCharacters * .8;
                const circleDashArray = Math.min( charactersProgress, circleCircumference );

                progressCircle.setAttribute( 'stroke-dasharray', `${ circleDashArray },${ circleCircumference }` );

                if ( isLimitExceeded ) {
                    charactersBox.textContent = `-${ stats.characters - maxCharacters }`;
                } else {
                    charactersBox.textContent = stats.characters;
                }

                wordsBox.textContent = `Words in the post: ${ stats.words }`;
                container.classList.toggle( 'demo-update__limit-close', isCloseToLimit );
                container.classList.toggle( 'demo-update__limit-exceeded', isLimitExceeded );
                sendButton.toggleAttribute( 'disabled', isLimitExceeded );
            }
        }
	})
	.then( editor => {
		window.editor = editor;
	} )
	.catch( handleSampleError );

function handleSampleError( error ) {
	const issueUrl = 'https://github.com/ckeditor/ckeditor5/issues';
	
	const message = [
		'Oops, something went wrong!',
		`Please, report the following error on ${ issueUrl } with the build id "n2v2yrn454nm-8rbp0wv4yzwe" and the error stack trace:`
	].join( '\n' );
	
	console.error( message );
	console.error( error );
}

function saveData( data ) {
    return new Promise( resolve => {
        setTimeout( () => {
            console.log( 'Saved', data );
/*            $.ajax({
              url: '/osd/shortages/update',
              type: 'POST',
              headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
              },
              data: {
                'shortage_id':'{{$shipmentShortage->id}}',
                'notes': data,
              },
              dataType: 'json',
              success: function (response) {
                console.log('saved');
              }
            });*/

            resolve();
        }, 5000 );
    } );
}

function displayStatus( editor ) {
    const pendingActions = editor.plugins.get( 'PendingActions' );
    const statusIndicator = document.querySelector( '#editor-status' );

    pendingActions.on( 'change:hasAny', ( evt, propertyName, newValue ) => {
        if ( newValue ) {
			statusIndicator.innerHTML = "<p>saving</p>";
            statusIndicator.classList.add( 'busy' );
        } else {
			statusIndicator.innerHTML = "<p>saved!</p>";
            statusIndicator.classList.remove( 'busy' );
        }
    } );
}