package com.github.lsp4intellij.extensions;

import com.github.lsp4intellij.client.languageserver.ServerOptions;
import com.github.lsp4intellij.client.languageserver.requestmanager.DefaultRequestManager;
import com.github.lsp4intellij.client.languageserver.requestmanager.RequestManager;
import com.github.lsp4intellij.client.languageserver.wrapper.LanguageServerWrapper;
import com.github.lsp4intellij.editor.EditorEventManager;
import com.github.lsp4intellij.editor.listeners.EditorMouseListenerImpl;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.editor.event.EditorMouseListener;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageServer;

import java.awt.event.MouseListener;

public interface LSPExtensionManager {

    <T extends DefaultRequestManager> T getExtendedRequestManagerFor(LanguageServerWrapper wrapper,
            LanguageServer server, LanguageClient client, ServerCapabilities serverCapabilities);

    <T extends EditorEventManager> T getExtendedEditorEventManagerFor(Editor editor, DocumentListener documentListener,
            EditorMouseListener mouseListener, RequestManager requestManager, ServerOptions serverOptions,
            LanguageServerWrapper wrapper);

    Class<? extends LanguageServer> getExtendedServerInterface();

}
