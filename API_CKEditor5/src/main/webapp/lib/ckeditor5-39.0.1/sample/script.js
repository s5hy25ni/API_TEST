ClassicEditor
	.create( document.querySelector( '.editor' ), {
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
		}
	} )
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
